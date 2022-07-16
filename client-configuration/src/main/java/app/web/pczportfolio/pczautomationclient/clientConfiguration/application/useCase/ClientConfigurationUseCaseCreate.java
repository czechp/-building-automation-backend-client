package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;

public interface ClientConfigurationUseCaseCreate {
    ClientConfiguration createClientConfigurationIfNotExists();
}
