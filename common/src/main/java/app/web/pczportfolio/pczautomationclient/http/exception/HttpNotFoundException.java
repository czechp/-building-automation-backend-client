package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException() {
        super("Cannot find element in external system or url does not exist");
    }
}
