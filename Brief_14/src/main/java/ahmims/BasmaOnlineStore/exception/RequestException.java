package ahmims.BasmaOnlineStore.exception;

import org.springframework.http.HttpStatus;

public class RequestException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public RequestException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
    public RequestException(HttpStatus httpStatus) {
        this.message = "";
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
