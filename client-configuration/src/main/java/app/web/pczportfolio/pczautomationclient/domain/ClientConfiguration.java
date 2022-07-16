package app.web.pczportfolio.pczautomationclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ClientConfiguration {
    private long id;
    private long version;
    private long locationId;
    private String clientName;
    private String clientHashCode;
    private String authenticationToken;


    public ClientConfiguration() {
        this.clientHashCode = UUID.randomUUID().toString();
        this.clientName = "Default name. You should change it";
    }


}
