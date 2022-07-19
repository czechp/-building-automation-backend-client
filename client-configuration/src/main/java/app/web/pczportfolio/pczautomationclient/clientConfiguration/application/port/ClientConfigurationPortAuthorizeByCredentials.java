package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;

public interface ClientConfigurationPortAuthorizeByCredentials {
    boolean userAuthenticated(ClientConfigurationLoginDto loginDto);
}
