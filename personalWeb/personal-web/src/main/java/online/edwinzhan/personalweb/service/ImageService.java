package online.edwinzhan.personalweb.service;

import online.edwinzhan.personalweb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import online.edwinzhan.personalweb.entity.Image;
import online.edwinzhan.personalweb.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public Image getImageById(Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if(optionalImage.isPresent()) {
            return optionalImage.get();
        } else {
            throw new ResourceNotFoundException("Image not found with id: " + id);
        }
    }
}
