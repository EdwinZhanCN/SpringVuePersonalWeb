package online.edwinzhan.personalweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import online.edwinzhan.personalweb.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
