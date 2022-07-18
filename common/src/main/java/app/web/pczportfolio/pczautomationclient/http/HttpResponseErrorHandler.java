package app.web.pczportfolio.pczautomationclient.http;

import app.web.pczportfolio.pczautomationclient.http.exception.*;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
public class HttpResponseErrorHandler {
    public void handleErrorByResponseStatusCode(int statusCode) {
        switch (statusCode){
            case 400: throw new HttpBadRequestException();
            case 401: throw new HttpUnauthorizedException();
            case 403: throw new HttpForbiddenException();
            case 404: throw new HttpNotFoundException();
            case 405: throw new HttpMethodNotAllowed();
            case 500: throw new HttpExternalSystemError();
        }
    }
}
