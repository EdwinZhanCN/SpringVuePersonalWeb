package online.edwinzhan.personalweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter//lombok
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String description;
    private byte[] fileData;
    private String uploadTime;

}
