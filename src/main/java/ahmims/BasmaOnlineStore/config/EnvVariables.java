package ahmims.BasmaOnlineStore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvVariables {
    public static int encryptionLength;

    @Value("${security.crypt.length}")
    public void setEncryptionLength(int value) {
        encryptionLength = value;
    }

}
