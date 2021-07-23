package ahmims.scuffed_BAKURA.validator.impl;

import ahmims.scuffed_BAKURA.validator.ImageValidator;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

@Service("ImageValidator")
public class ImageValidatorImpl implements ImageValidator {
    @Override
    public boolean isValidImageLink(String url) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            return image != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isValidLocalImageLink(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
