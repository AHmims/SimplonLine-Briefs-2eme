package ahmims.BasmaOnlineStore.dto;

public class Validation {
    private boolean result;
    private String message;
    //

    public Validation(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Validation() {
    }
    //

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
