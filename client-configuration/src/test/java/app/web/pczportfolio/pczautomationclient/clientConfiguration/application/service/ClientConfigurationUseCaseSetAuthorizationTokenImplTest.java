package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthenticateUser;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseSetAuthorizationToken;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import app.web.pczportfolio.pczautomationclient.exception.clientConfiguration.InvalidUsernameOrPassword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationUseCaseSetAuthorizationTokenImplTest {
    @Mock
    ClientConfigurationProviderService configurationProviderService;
    @Mock
    ClientConfigurationPortAuthenticateUser configurationPortAuthenticateUser;
    @Mock
    ClientConfigurationPortSave configurationPortSave;

    ClientConfigurationUseCaseSetAuthorizationToken useCaseSetAuthorizationToken;

    @BeforeEach
    void init() {
        this.useCaseSetAuthorizationToken = new ClientConfigurationUseCaseSetAuthorizationTokenImpl(
                configurationProviderService,
                configurationPortAuthenticateUser,
                configurationPortSave
        );
    }

    @Test
    void assignAuthorizationTokenTest() {
        //given
        final var fetchedConfiguration = new ClientConfiguration();
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        //when
        when(configurationProviderService.getConfigurationOrCreateIfNotExists()).thenReturn(fetchedConfiguration);
        when(configurationPortAuthenticateUser.userAuthenticated(any())).thenReturn(true);
        final var configurationWithSetAuthorizationToken = useCaseSetAuthorizationToken.assignAuthorizationToken(loginDto);
        //then
        verify(configurationPortSave, times(1)).save(any());
        assertNotEquals("", configurationWithSetAuthorizationToken.getAuthenticationToken());
    }


    @Test
    void assignAuthorizationTokenUserNotAuthenticatedTest() {
        //given
        final var fetchedConfiguration = new ClientConfiguration();
        final var loginDto = new ClientConfigurationLoginDto("someUsername", "somePassword");
        //when
        when(configurationProviderService.getConfigurationOrCreateIfNotExists()).thenReturn(fetchedConfiguration);
        when(configurationPortAuthenticateUser.userAuthenticated(any())).thenReturn(false);
        //then
        assertThrows(InvalidUsernameOrPassword.class, () -> useCaseSetAuthorizationToken.assignAuthorizationToken(loginDto));
    }
}