package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationUserDetailsDto;

import java.util.Optional;

public interface ClientConfigurationUseCaseAuthorization {
    Optional<ClientConfigurationUserDetailsDto> authenticateUser(String authorizationHeader);
}
