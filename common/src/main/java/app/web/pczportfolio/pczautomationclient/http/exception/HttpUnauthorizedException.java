package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpUnauthorizedException extends RuntimeException {
    public HttpUnauthorizedException() {
        super("You are unauthorized in external system");
    }
}
