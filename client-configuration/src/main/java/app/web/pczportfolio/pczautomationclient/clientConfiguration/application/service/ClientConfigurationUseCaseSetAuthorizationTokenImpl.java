package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortAuthenticateUser;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseSetAuthorizationToken;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class ClientConfigurationUseCaseSetAuthorizationTokenImpl implements ClientConfigurationUseCaseSetAuthorizationToken {
    private final ClientConfigurationProviderService configurationProviderService;
    private final ClientConfigurationPortAuthenticateUser authenticateUser;
    private final ClientConfigurationPortSave configurationPortSave;

    @Override
    @Transactional
    public ClientConfiguration assignAuthorizationToken(ClientConfigurationLoginDto loginDto) {
        return null;
    }
}
