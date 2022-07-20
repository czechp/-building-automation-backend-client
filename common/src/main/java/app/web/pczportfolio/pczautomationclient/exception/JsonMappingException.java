package app.web.pczportfolio.pczautomationclient.exception;

public class JsonMappingException extends RuntimeException {
    public JsonMappingException() {
        super("Error during JSON processing");
    }
}
