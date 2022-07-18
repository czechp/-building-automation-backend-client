package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.http;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthenticateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationHttpAdapterSetAuthorizationTokenTest {
    @BeforeEach
    void init() {
    }
}