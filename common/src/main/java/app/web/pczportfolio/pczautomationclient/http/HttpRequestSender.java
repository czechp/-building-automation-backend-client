package app.web.pczportfolio.pczautomationclient.http;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpRequestSender {
    HttpResponse<String> sendToBackendAndResolveErrors(HttpRequest.Builder requestBuilder, String endpoint);
    HttpResponse<String> sendToBackend(HttpRequest.Builder requestBuilder, String endpoint);

}
