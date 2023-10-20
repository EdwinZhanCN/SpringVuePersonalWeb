package online.edwinzhan.personalweb.repository;

import com.azure.storage.blob.*;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import jakarta.annotation.Resource;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.tag.*;
import online.edwinzhan.personalweb.entity.Song;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SongRepository {

    @Resource
    private BlobContainerClient blobContainerClient;

    public List<Song> findAllSongs() throws Exception {
        List<Song> songs = new ArrayList<>();

        Map<String, String> songUrls = new HashMap<>();
        Map<String, String> lrcUrls = new HashMap<>();
        try {
            for (BlobItem blobItem : blobContainerClient.listBlobs()) {
                String name = blobItem.getName();
                String blobUrl = blobContainerClient.getBlobClient(name).getBlobUrl();
                if (name.endsWith(".m4a")) {
                    String baseName = name.substring(0, name.lastIndexOf('.'));
                    songUrls.put(baseName, blobUrl);
                } else {
                    String baseName = name.substring("lyric".length());
                    lrcUrls.put(baseName, blobUrl);
                }
            }
        }catch (Exception e) {
            throw new Exception(e);
        }

        for (String baseName : songUrls.keySet()) {
            //
            String songUrl = songUrls.get(baseName);
            BlobClient blobClient = blobContainerClient.getBlobClient(baseName + ".m4a");

            //the lrc file name is lyric + song file name
            String lrcBaseName = "/lyric/lyric" + baseName.substring("song/".length());
            // Now try to match based on naming convention
            String lrcUrl = lrcUrls.get(lrcBaseName);

            //Download the blob to a local file, and get the metadata
            File tempFile = Files.createTempFile("song-", ".m4a").toFile();
            //check if the temp file is deleted
            boolean isDelete = tempFile.delete();
            System.out.println(isDelete);

            blobClient.downloadToFile(tempFile.getAbsolutePath());

            //Get the metadata
            AudioFile audioFile = AudioFileIO.read(tempFile);
            Tag tag = audioFile.getTag();

            //create a new song object
            Song song = new Song(
                    tag.getFirst(FieldKey.TITLE),
                    tag.getFirst(FieldKey.ARTIST),
                    tag.getFirst(FieldKey.GENRE),
                    songUrl, lrcUrl
            );

            //add the song object into the list
            songs.add(song);

        }
        System.out.println("I am here: findAllSongs return");
        return songs;
    }
}

