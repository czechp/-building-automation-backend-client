package app.web.pczportfolio.pczautomationclient.exception.clientConfiguration;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException() {
        super("Invalid username or password");
    }
}
