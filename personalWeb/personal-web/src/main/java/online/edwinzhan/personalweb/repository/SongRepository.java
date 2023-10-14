package online.edwinzhan.personalweb.repository;

import com.azure.storage.blob.BlobClient;
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
        for (BlobItem blobItem : blobContainerClient.listBlobs()) {
            String name = blobItem.getName();
            String blobUrl = blobContainerClient.getBlobClient(name).getBlobUrl();
            if (name.endsWith(".m4a")) {
                String baseName = name.substring(0, name.lastIndexOf('.'));
                songUrls.put(baseName, blobUrl);
            } else if (name.endsWith(".lrc")) {
                String baseName = name.substring("lyric".length(), name.lastIndexOf('.'));
                lrcUrls.put(baseName, blobUrl);
            }
        }

        for (String baseName : songUrls.keySet()) {
            String songUrl = songUrls.get(baseName);
            BlobClient blobClient = blobContainerClient.getBlobClient(baseName + ".m4a");

            String lrcBaseName = "lyric" + baseName;
            String lrcUrl = lrcUrls.get(lrcBaseName);  // Now attempting to match based on naming convention

            File tempFile = Files.createTempFile("song-", ".m4a").toFile();
            blobClient.downloadToFile(tempFile.getAbsolutePath());

            AudioFile audioFile = AudioFileIO.read(tempFile);
            Tag tag = audioFile.getTag();

            Song song = new Song(
                    tag.getFirst(FieldKey.TITLE),
                    tag.getFirst(FieldKey.ARTIST),
                    tag.getFirst(FieldKey.GENRE),
                    songUrl, lrcUrl
            );
            songs.add(song);
            tempFile.delete();
        }
        return songs;
    }
}

