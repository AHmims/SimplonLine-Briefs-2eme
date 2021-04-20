package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Utilisateur;

public class EmailFormat {
    private String receiver;
    private String subject;
    private String content;
    //

    public EmailFormat(String receiver, String subject, String content) {
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
    }

    public EmailFormat() {
    }
    //

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //
    //
}
