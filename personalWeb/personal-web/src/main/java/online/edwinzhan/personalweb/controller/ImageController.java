package online.edwinzhan.personalweb.controller;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.entity.Image;
import online.edwinzhan.personalweb.entity.RestBean;
import online.edwinzhan.personalweb.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/image")
public class ImageController {
    @Resource
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(
            @RequestParam("file") MultipartFile file, String description) throws IOException {
        Image image = new Image();
        image.setFilename(file.getOriginalFilename());
        image.setFileData(file.getBytes());
        image.setDescription(description);
        image.setUploadTime(LocalDateTime.now());
        Image savedImage = imageService.saveImage(image);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping("/{id}")
    public RestBean<byte[]> getImage( @PathVariable Long id){
        byte[] wrongMessage = {40,4};
        byte[] image = imageService.getImageById(id);
        if(image != null){
            return RestBean.success(image);
        }
        return RestBean.failure(404,wrongMessage);
    }
}



