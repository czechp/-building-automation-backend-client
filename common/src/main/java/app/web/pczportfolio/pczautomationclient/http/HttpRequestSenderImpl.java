package app.web.pczportfolio.pczautomationclient.http;

import app.web.pczportfolio.pczautomationclient.http.exception.HttpRequestSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
class HttpRequestSenderImpl implements HttpRequestSender {
    private final HttpResponseErrorHandler httpResponseErrorHandler;
    @Value("${backend.url}")
    private String BACKEND_URL;

    @Autowired
    HttpRequestSenderImpl(HttpResponseErrorHandler httpResponseErrorHandler) {
        this.httpResponseErrorHandler = httpResponseErrorHandler;
    }

    @Override
    public HttpResponse<String> sendToBackendAndResolveErrors(HttpRequest.Builder requestBuilder, String endpoint) {
        final HttpResponse<String> httpResponse = sendRequest(requestBuilder, endpoint);
        httpResponseErrorHandler.handleErrorByResponseStatusCode(httpResponse.statusCode());
        return httpResponse;
    }


    @Override
    public HttpResponse<String> sendToBackend(HttpRequest.Builder requestBuilder, String endpoint) {
        return sendRequest(requestBuilder, endpoint);
    }

    private HttpResponse<String> sendRequest(HttpRequest.Builder requestBuilder, String endpoint) {
        final var httpRequest = prepareRequest(requestBuilder, endpoint);
        return send(httpRequest);
    }


    HttpResponse<String> send(HttpRequest httpRequest) {
        final var httpClient = HttpClient.newBuilder().build();
        try {
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new HttpRequestSendException("Error during sending request to backend system");
        }
    }

    HttpRequest prepareRequest(HttpRequest.Builder requestBuilder, String endpoint) {
        try {
            return requestBuilder
                    .uri(new URI(BACKEND_URL + endpoint))
                    .build();
        } catch (URISyntaxException e) {
            throw new HttpRequestSendException("Error during creating URL: " + BACKEND_URL + endpoint);
        }
    }
}
