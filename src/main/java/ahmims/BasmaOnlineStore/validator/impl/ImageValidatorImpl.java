package ahmims.BasmaOnlineStore.validator.impl;

import ahmims.BasmaOnlineStore.validator.ImageValidator;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service("ImageValidator")
public class ImageValidatorImpl implements ImageValidator {
    @Override
    public boolean isValidImageLink(String url) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            return image != null;
        } catch (IOException ignored) {
        }
        return false;
    }
}
