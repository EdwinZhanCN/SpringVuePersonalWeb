package online.edwinzhan.personalweb.controller;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.entity.RestBean;
import online.edwinzhan.personalweb.entity.Song;
import online.edwinzhan.personalweb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    @Resource
    private SongService songService;

    @GetMapping("/songs")
    public RestBean<List<Song>> findAllSongs() throws Exception {
        try {
            List<Song> song= songService.findAllSongs();
            return RestBean.success(song);
        } catch (Exception e) {
            return RestBean.failure();
        }
    }
}
