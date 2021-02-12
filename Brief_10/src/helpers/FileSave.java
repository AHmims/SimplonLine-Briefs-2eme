package helpers;

import javax.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Executable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileSave {
    public static String save(Part part, String type) {
        try {
            //https://stackoverflow.com/a/2424824/14427192
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String extension = fileName.substring(fileName.indexOf("."));
            switch (type) {
                case "image":
                    final ArrayList<String> ext = new ArrayList<>(List.of(".jfif", ".png", ".jpeg", ".jpg", ".webp", ".bmp", ".tiff", ".tif"));
                    if (!ext.contains(extension)) {
                        return "EXT_NOT_SUPPORTED";
                    }
                    break;
                default:
                    return "EXT_UNKNOWN";
            }
            InputStream fileContent = part.getInputStream();
            //https://stackoverflow.com/a/18664715/14427192
            InputStream in = Connexion.class.getResourceAsStream("/other.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            Files.createDirectories(Paths.get(props.getProperty("path")));
            //
            File uploads = new File(props.getProperty("path"));
            File file = new File(uploads, fileName);
            try (InputStream input = fileContent) {
                Files.copy(input, file.toPath());
            }
            //
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
