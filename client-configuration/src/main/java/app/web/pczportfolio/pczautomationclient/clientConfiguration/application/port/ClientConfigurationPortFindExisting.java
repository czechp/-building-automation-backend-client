package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;

import java.util.Optional;

public interface ClientConfigurationPortFindExisting {
    Optional<ClientConfiguration> findExistingConfiguration();
}
