package app.web.pczportfolio.pczautomationclient.clientConfiguration.domain;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Base64;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ClientConfiguration {
    private long id;
    private long version;
    private long locationId;
    private String clientName = "";
    private String clientHashCode = "";
    private String authenticationToken = "";


    public ClientConfiguration() {
        this.clientHashCode = UUID.randomUUID().toString();
        this.clientName = "Default name. You should change it";
    }


    public void assignAuthorizationToken(ClientConfigurationLoginDto loginDto) {
        final var encodedToken = Base64.getEncoder().encodeToString(new String(loginDto.getUsername() + ":" + loginDto.getPassword()).getBytes());
        this.authenticationToken = new StringBuilder()
                .append("Basic ")
                .append(encodedToken)
                .toString();
    }
}
