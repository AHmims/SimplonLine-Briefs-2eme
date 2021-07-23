package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

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
        File image = imageService.getLocalImage(imageName);

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
