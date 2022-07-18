package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpForbiddenException extends RuntimeException {
    public HttpForbiddenException() {
        super("You have no permission to request resource in external system");
    }
}
