//package online.edwinzhan.personalweb.service;
//
//import com.azure.core.exception.AzureException;
//import com.azure.storage.file.share.ShareClient;
//import com.azure.storage.file.share.ShareClientBuilder;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//public class SongService {
//    public SongService(String connectionString, String shareName) {
//        try{
//            ShareClient shareClient = new ShareClientBuilder()
//                    .connectionString(connectionString)
//                    .shareName(shareName)
//                    .buildClient();
//        }catch (AzureException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    public void uploadFiles(File lyricFile, File songFile) {
//        UUID songId = UUID.randomUUID();
//
//        String lyricFileName = songId.toString() + "_lyric.txt";
//        String mp3FileName = songId.toString() + "_song.mp3";
//
//        saveFile(lyricFileName, lyricFile);
//        saveFile(mp3FileName, songFile);
//
//        saveFileInfoToDatabase(songId, lyricFileName, mp3FileName);
//    }
//
//    private void saveFile(String fileName, File fileData) {
//
//    }
//
//    private void saveFileInfoToDatabase(UUID songId, String lyricFileName, String mp3FileName) {
//        // 实现在数据库中保存文件信息的逻辑
//    }
//}
//
