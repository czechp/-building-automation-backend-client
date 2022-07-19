package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpExternalSystemError extends RuntimeException {
    public HttpExternalSystemError() {
        super("Error during processing request in external system");
    }
}
