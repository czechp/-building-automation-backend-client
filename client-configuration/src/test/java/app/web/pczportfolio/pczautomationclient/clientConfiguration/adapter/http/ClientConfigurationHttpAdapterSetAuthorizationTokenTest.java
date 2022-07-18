package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.http;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthenticateUser;
import app.web.pczportfolio.pczautomationclient.http.HttpRequestSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationHttpAdapterSetAuthorizationTokenTest {
    @Mock
    HttpRequestSender httpRequestSender;

    ClientConfigurationPortAuthenticateUser configurationPortAuthenticateUser;

    @BeforeEach
    void init() {
        this.configurationPortAuthenticateUser = new ClientConfigurationHttpAdapterSetAuthorizationToken(httpRequestSender);
    }

    @Test
    void userAuthenticatedTest() {
        //given
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        final var response = createResponse(200);
        //when
        when(httpRequestSender.sendToBackend(any(), anyString())).thenReturn(response);
        final var isAuthenticated = configurationPortAuthenticateUser.userAuthenticated(loginDto);
        //then
        assertTrue(isAuthenticated);
    }

    @Test
    void userAuthenticatedUnauthenticatedTest() {
        //given
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        final var response = createResponse(401);
        //when
        when(httpRequestSender.sendToBackend(any(), anyString())).thenReturn(response);
        final var isAuthenticated = configurationPortAuthenticateUser.userAuthenticated(loginDto);
        //then
        assertFalse(isAuthenticated);
    }


    private HttpResponse<String> createResponse(int statusCode) {
        return new HttpResponse<String>() {
            @Override
            public int statusCode() {
                return statusCode;
            }

            @Override
            public HttpRequest request() {
                return null;
            }

            @Override
            public Optional<HttpResponse<String>> previousResponse() {
                return Optional.empty();
            }

            @Override
            public HttpHeaders headers() {
                return null;
            }

            @Override
            public String body() {
                return null;
            }

            @Override
            public Optional<SSLSession> sslSession() {
                return Optional.empty();
            }

            @Override
            public URI uri() {
                return null;
            }

            @Override
            public HttpClient.Version version() {
                return null;
            }
        };
    }
}