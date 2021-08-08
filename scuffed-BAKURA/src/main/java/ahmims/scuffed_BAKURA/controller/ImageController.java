package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    //#region
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //#endregion
    @PostMapping("")
    public ResponseEntity<List<Image>> postLogin(@RequestParam("images") MultipartFile[] images) {
        return new ResponseEntity<>(this.imageService.uploadMultiple(images), HttpStatus.valueOf(200));
    }

}
