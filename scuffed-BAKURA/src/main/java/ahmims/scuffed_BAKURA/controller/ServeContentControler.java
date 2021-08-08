package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("/serve")
public class ServeContentControler {
    //#region
    private final ImageService imageService;

    public ServeContentControler(ImageService imageService) {
        this.imageService = imageService;
    }

    //#endregion

    @GetMapping("/images/{imageName}")
    public ResponseEntity<?> postLogin(@PathVariable String imageName) {
        File image = this.imageService.getLocalImage(imageName);

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(Files.probeContentType(image.toPath())))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + imageName + "\"")
                    .contentLength(image.length())
                    .body(new ByteArrayResource(Files.readAllBytes(image.toPath())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
