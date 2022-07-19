package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.http;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthenticateUser;
import app.web.pczportfolio.pczautomationclient.http.HttpRequestSender;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Service
@AllArgsConstructor
class ClientConfigurationHttpAdapterSetAuthorizationToken implements ClientConfigurationPortAuthenticateUser {
    private static final String LOGIN_ENDPOINT = "/api/external-login";

    private final HttpRequestSender httpRequestSender;

    @Override
    public boolean userAuthenticated(ClientConfigurationLoginDto loginDto) {
        final var authenticationRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", createBasicAuthorizationHeader(loginDto));

        HttpResponse<String> httpResponse = httpRequestSender.sendToBackend(authenticationRequest, LOGIN_ENDPOINT);
        return isAuthenticated(httpResponse);
    }

    private boolean isAuthenticated(HttpResponse<String> httpResponse) {
        return httpResponse.statusCode() == 200;
    }

    private String createBasicAuthorizationHeader(ClientConfigurationLoginDto loginDto) {
        final var hashCode = Base64.getEncoder()
                .encodeToString(new String(loginDto.getUsername() + ":" + loginDto.getPassword()).getBytes());
        return "Basic " + hashCode;
    }

}
