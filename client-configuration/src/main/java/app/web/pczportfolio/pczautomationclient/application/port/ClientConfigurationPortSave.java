package app.web.pczportfolio.pczautomationclient.application.port;

import app.web.pczportfolio.pczautomationclient.domain.ClientConfiguration;

public interface ClientConfigurationPortSave {
    ClientConfiguration save(ClientConfiguration clientConfiguration);
}
