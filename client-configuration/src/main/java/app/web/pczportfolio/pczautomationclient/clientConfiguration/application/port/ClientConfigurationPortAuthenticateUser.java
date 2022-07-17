package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;

public interface ClientConfigurationPortAuthenticateUser {
    boolean userAuthenticated(ClientConfigurationLoginDto loginDto);
}
