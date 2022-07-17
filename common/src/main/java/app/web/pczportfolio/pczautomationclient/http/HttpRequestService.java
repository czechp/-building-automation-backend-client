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

    public HttpResponse<String> send(HttpRequest httpRequest) throws IOException, InterruptedException {
        return HttpClient.newBuilder()
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
    public class Builder {
        private HttpRequest.Builder requestBuilder;

        public Builder() {
            this.requestBuilder = HttpRequest.newBuilder();
        }


        public Builder toBackend(String endpoint) throws URISyntaxException {
            this.requestBuilder.uri(new URI(BACKEND_URL + endpoint));
            return this;
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
