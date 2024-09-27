package online.edwinzhan.personalweb.entity;

import com.azure.core.annotation.Get;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "photograph")
public class Photograph {
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
