package app.web.pczportfolio.pczautomationclient.http.exception;

public class HttpMethodNotAllowed extends RuntimeException {
    public HttpMethodNotAllowed() {
        super("URL in external system does not support this http method");
    }
}
