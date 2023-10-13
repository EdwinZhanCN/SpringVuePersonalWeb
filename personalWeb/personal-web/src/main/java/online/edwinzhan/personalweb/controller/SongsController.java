//package online.edwinzhan.personalweb.controller;
//
//import online.edwinzhan.personalweb.entity.RestBean;
//import java.util.UUID;
//
//import online.edwinzhan.personalweb.entity.Song;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//
////String connectionString = "DefaultEndpointsProtocol=https;AccountName=edwinzhanfile;AccountKey=iq/Zxs4O5KUBO7Fpb2Kkw649b66kaz7Nnn76c1NyMJh/ZuQHFCR7/gqeYO4suCR1HN2lEYsES0KB+AStR0bwnw==;EndpointSuffix=core.windows.net";
////        ShareServiceClient serviceClient = new ShareServiceClientBuilder()
////        .connectionString(connectionString)
////        .buildClient();
//@RestController
//@RequestMapping("/api/songs")
//public class SongsController {
//    @GetMapping("/list")
//    public RestBean<Song> list(
//            @RequestParam UUID songId){
//        Song song = new Song();
//        return RestBean.success(song);
//    }
//}
