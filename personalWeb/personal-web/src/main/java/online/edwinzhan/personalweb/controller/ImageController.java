package online.edwinzhan.personalweb.controller;

import online.edwinzhan.personalweb.entity.Image;
import online.edwinzhan.personalweb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("description") String description) throws IOException {
        Image image = new Image();
        image.setFilename(file.getOriginalFilename());
        image.setFileData(file.getBytes());
        image.setDescription(description);
        image.setUploadTime(LocalDateTime.now());
        Image savedImage = imageService.saveImage(image);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
                .body(image.getFileData());
    }
}



