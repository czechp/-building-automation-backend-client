package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;

public interface ClientConfigurationPortSave {
    ClientConfiguration save(ClientConfiguration clientConfiguration);
}
