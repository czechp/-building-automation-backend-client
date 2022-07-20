package app.web.pczportfolio.pczautomationclient.configuration.security.userDetailService;

import app.web.pczportfolio.pczautomationclient.exception.JsonMappingException;
import app.web.pczportfolio.pczautomationclient.http.HttpRequestSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@AllArgsConstructor
class UserDetailsServiceAuthorizationRequestImpl implements UserDetailsServiceAuthorizationRequest {
    private static final String LOGIN_ENDPOINT = "/api/external-login";
    private final HttpRequestSender httpRequestSender;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<UserDetailsDto> authorizeUserByHeader(String authorizationHeader) {
        HttpResponse<String> authorizationResponse = sendAuthorizeRequest(authorizationHeader);
        return userAuthorized(authorizationResponse.statusCode()) ? mapToDto(authorizationResponse.body()) : Optional.empty();
    }

    private HttpResponse<String> sendAuthorizeRequest(String authorizationHeader) {
        final var requestBuilder = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", authorizationHeader);
        return httpRequestSender.sendToBackendAndResolveErrors(requestBuilder, LOGIN_ENDPOINT);
    }

    private boolean userAuthorized(int statusCode) {
        return statusCode == 200;
    }

    private Optional<UserDetailsDto> mapToDto(String body) {
        try {
            UserDetailsDto userDetailsDto = objectMapper.readValue(body, UserDetailsDto.class);
            return Optional.of(userDetailsDto);
        } catch (JsonProcessingException e) {
            throw new JsonMappingException();
        }
    }

}
