package online.edwinzhan.personalweb.service;

import online.edwinzhan.personalweb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import online.edwinzhan.personalweb.entity.Image;
import online.edwinzhan.personalweb.repository.ImageRepository;

import java.util.List;
import java.util.Optional;
/*
Using JPA Repo to complete the auto update of the database
 */
@Service
public class ImageService {

    private final ImageRepository imageRepository;
    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public byte[] getImageById(Long id) {
        return imageRepository.findById(id)
                .map(Image::getFileData)
                .orElse(null);
    }

}
