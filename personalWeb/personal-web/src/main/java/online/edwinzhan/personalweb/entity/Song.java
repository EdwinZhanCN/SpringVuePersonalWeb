package online.edwinzhan.personalweb.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class Song {

    private String title;
    private String artist;
    private String genre;
    private String blobUrl;
    private String lrcUrl;

    public Song(String title, String artist, String genre, String blobUrl, String lrcUrl) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.blobUrl = blobUrl;
        this.lrcUrl = lrcUrl;
    }

}

