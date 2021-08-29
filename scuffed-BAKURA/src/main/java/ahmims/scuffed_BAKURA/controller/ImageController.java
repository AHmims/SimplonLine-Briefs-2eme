package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:6969")
@RestController
@RequestMapping("/api/image")
public class ImageController {
    public static List<String> avatarsIds = new ArrayList<>(
            List.of("c975552a-9faa-4c9b-bd2e-8833946014af",
                    "13c0081a-88c3-4f74-8165-345fc75e414d",
                    "330745ff-dbc0-4506-b535-5b1c33cc19b7",
                    "5a3f568d-f227-41f0-8afd-770e4d0d6a5d",
                    "3b045031-a861-4ed6-be1d-2cd129acbfa6",
                    "b191bb00-f0a2-457a-8e6f-1a64f12e9bbb",
                    "4993bc8a-7bd7-4e2b-98ec-5537aa19b995"
            ));
    //#region
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //#endregion

    //Upload images
    @PostMapping("")
    public ResponseEntity<List<Image>> uploadImages(@RequestParam("images") MultipartFile[] images) {
        return new ResponseEntity<>(this.imageService.uploadMultiple(images), HttpStatus.valueOf(200));
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> deleteImages(@RequestBody Image[] images) {
        return new ResponseEntity<>(this.imageService.deleteImages(images), HttpStatus.valueOf(200));
    }

    //Get default avatars
    @GetMapping("/avatars")
    public ResponseEntity<List<Image>> getAvatars() {
        return new ResponseEntity<>(this.imageService.getImagesById(ImageController.avatarsIds), HttpStatus.valueOf(200));
    }
}
