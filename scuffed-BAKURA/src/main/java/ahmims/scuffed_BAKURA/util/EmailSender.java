package ahmims.scuffed_BAKURA.util;

import ahmims.scuffed_BAKURA.dto.EmailFormat;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import javax.mail.internet.MimeMessage;

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
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            //
            helper.setTo(emailFormat.getReceiver());
            helper.setSubject(emailFormat.getSubject());
            helper.setText(emailFormat.getContent(), true);
            //
            javaMailSender.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
