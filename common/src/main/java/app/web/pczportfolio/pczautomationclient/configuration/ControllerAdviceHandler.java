package app.web.pczportfolio.pczautomationclient.configuration;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.exception.InvalidUsernameOrPasswordException;
import app.web.pczportfolio.pczautomationclient.exception.JsonMappingException;
import app.web.pczportfolio.pczautomationclient.http.exception.*;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
class ControllerAdviceHandler {
    @ExceptionHandler({InvalidUsernameOrPasswordException.class, HttpUnauthorizedException.class})
    public ResponseEntity<Map<String, String>> unauthorizedExceptionHandler(Exception exception) {
        return createResponseEntity(HttpStatus.UNAUTHORIZED, exception.getMessage());
    }

    @ExceptionHandler({HttpBadRequestException.class, HttpRequestSendException.class, JsonMappingException.class})
    public ResponseEntity<Map<String, String>> badRequestHandler(Exception exception) {
        return createResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler({HttpExternalSystemError.class})
    public ResponseEntity<Map<String, String>> systemErrorExceptionHandler(Exception exception) {
        return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }


    @ExceptionHandler({HttpForbiddenException.class})
    public ResponseEntity<Map<String, String>> forbiddenExceptionHandler(Exception exception) {
        return createResponseEntity(HttpStatus.FORBIDDEN, exception.getMessage());
    }


    @ExceptionHandler({HttpMethodNotAllowed.class})
    public ResponseEntity<Map<String, String>> methodNotAllowedExceptionHandler(Exception exception) {
        return createResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, exception.getMessage());
    }

    @ExceptionHandler({HttpNotFoundException.class})
    public ResponseEntity<Map<String, String>> notFoundExceptionHandler(Exception exception) {
        return createResponseEntity(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    private ResponseEntity<Map<String, String>> createResponseEntity(HttpStatus httpStatus, String message) {
        final var responseBody = new HashMap<String, String>();
        responseBody.put("timestamp", LocalDateTime.now().toString());
        responseBody.put("message", message);

        return new ResponseEntity<Map<String, String>>(responseBody, httpStatus);
    }
}
