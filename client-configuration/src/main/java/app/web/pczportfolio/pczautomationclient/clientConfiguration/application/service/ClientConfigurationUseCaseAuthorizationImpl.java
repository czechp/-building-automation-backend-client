package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationUserDetailsDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseAuthorization;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ClientConfigurationUseCaseAuthorizationImpl implements ClientConfigurationUseCaseAuthorization {

    @Override
    public Optional<ClientConfigurationUserDetailsDto> authenticateUser(String authorizationHeader) {
        return Optional.empty();
    }
}
