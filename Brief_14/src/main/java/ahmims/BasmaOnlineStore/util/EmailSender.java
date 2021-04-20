package ahmims.BasmaOnlineStore.util;

import ahmims.BasmaOnlineStore.dto.EmailFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository("EmailSender")
public class EmailSender {
    //#region
    private final JavaMailSender javaMailSender;

    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //#endregion
    //
    public boolean sendEmail(EmailFormat emailFormat) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            //
            msg.setTo(emailFormat.getReceiver());
            msg.setSubject(emailFormat.getSubject());
            msg.setText(emailFormat.getContent());
            //
            javaMailSender.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
