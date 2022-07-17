package app.web.pczportfolio.pczautomationclient.http;

import app.web.pczportfolio.pczautomationclient.http.exception.HttpRequestSendException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Service
public class HttpRequestService {
    @Value("${backend.url}")
    private String BACKEND_URL;
    private final Logger logger;

    public HttpRequestService() {
        this.logger = LoggerFactory.getLogger(HttpRequestService.class);
    }

    public HttpResponse<String> send(HttpRequest httpRequest) {
        try {
            return HttpClient.newBuilder()
                    .build()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception exception) {
            logger.info(exception.getLocalizedMessage());
            throw new HttpRequestSendException("Error during sending request");
        }
    }

    public class Builder {
        private final HttpRequest.Builder requestBuilder;

        public Builder() {
            this.requestBuilder = HttpRequest.newBuilder();
        }


        public Builder toBackend(String endpoint) {
            try {
                this.requestBuilder.uri(new URI(BACKEND_URL + endpoint));
                return this;
            } catch (URISyntaxException e) {
                logger.info(e.getLocalizedMessage());
                throw new HttpRequestSendException("Error during converting URL address");
            }
        }

        public Builder withAuthorization(String username, String password) {
            String authorizationHashCode = Base64.getEncoder().encodeToString(new String(username + ":" + password).getBytes());
            this.requestBuilder.header("Authorization", "BASIC " + authorizationHashCode);
            return this;
        }

        public Builder getMethod() {
            this.requestBuilder.GET();
            return this;
        }

        public HttpRequest build() {
            return this.requestBuilder.build();
        }
    }
}
