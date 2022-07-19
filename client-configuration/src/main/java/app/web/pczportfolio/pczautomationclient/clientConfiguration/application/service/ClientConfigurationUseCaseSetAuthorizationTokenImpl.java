package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthorizeByCredentials;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseSetAuthorizationToken;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.exception.InvalidUsernameOrPasswordException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class ClientConfigurationUseCaseSetAuthorizationTokenImpl implements ClientConfigurationUseCaseSetAuthorizationToken {
    private final ClientConfigurationProviderService configurationProviderService;
    private final ClientConfigurationPortAuthorizeByCredentials authenticateUser;
    private final ClientConfigurationPortSave configurationPortSave;

    @Override
    @Transactional
    public ClientConfiguration assignAuthorizationToken(ClientConfigurationLoginDto loginDto) {
        final var configuration = configurationProviderService.getConfigurationOrCreateIfNotExists();
        if (authenticateUser.userAuthenticated(loginDto)) {
            configuration.assignAuthorizationToken(loginDto);
            configurationPortSave.save(configuration);
            return configuration;
        } else
            throw new InvalidUsernameOrPasswordException();
    }
}
