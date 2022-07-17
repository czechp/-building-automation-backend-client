package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;

public interface ClientConfigurationUseCaseSetAuthorizationToken {
    ClientConfiguration assignAuthorizationToken(ClientConfigurationLoginDto loginDto);
}