package online.edwinzhan.personalweb.service;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.entity.Song;
import online.edwinzhan.personalweb.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Resource
    private SongRepository songRepository;

    public List<Song> findAllSongs() throws Exception {
        return songRepository.findAllSongs();
    }
}

