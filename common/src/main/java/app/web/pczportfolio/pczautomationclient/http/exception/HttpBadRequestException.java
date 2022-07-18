package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpBadRequestException extends RuntimeException {
    public HttpBadRequestException() {
        super("Error during sending http request to external system");
    }
}
