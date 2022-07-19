package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.rest;

import app.web.pczportfolio.pczautomationclient.TestHttpResponseCreator;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.http.HttpRequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
class ClientConfigurationRestAdapterSetAuthorizationTokenTest {
    private static final String URL = "/api/configuration/login";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    HttpRequestSender httpRequestSender;

    @Test
    void authenticateUserTest() throws Exception {
        //given
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        final var responseFromBackend = TestHttpResponseCreator.createResponseWithStatus(200);
        final var requestBody = objectMapper.writeValueAsString(loginDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody);
        //when
        when(httpRequestSender.sendToBackend(any(), anyString())).thenReturn(responseFromBackend);
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void unauthenticatedUserTest() throws Exception {
        //given
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        final var responseFromBackend = TestHttpResponseCreator.createResponseWithStatus(401);
        final var requestBody = objectMapper.writeValueAsString(loginDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody);
        //when
        when(httpRequestSender.sendToBackend(any(), anyString())).thenReturn(responseFromBackend);
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }


}
