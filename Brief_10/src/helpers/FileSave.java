package helpers;

import javax.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Executable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FileSave {
    public static String save(Part part){
        try{
            //https://stackoverflow.com/a/2424824/14427192
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            System.out.println((Paths.get(part.getSubmittedFileName())).getFileName().toAbsolutePath());
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
            System.out.println(System.getProperty("user.dir"));
            System.out.println(file.getAbsolutePath());
            //System.out.println(getServletContext());
            try (InputStream input = fileContent) {
                Files.copy(input, file.toPath());
            }
            //
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
