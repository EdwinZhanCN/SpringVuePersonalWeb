package online.edwinzhan.personalweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter//lombok
@Setter
@Entity
@Table(name = "Images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String description;

    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] fileData;

    private LocalDateTime uploadTime;

}
