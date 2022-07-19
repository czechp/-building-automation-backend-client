package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.persistence;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_configuration")
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
class ClientConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    private long locationId;

    private String clientName;

    private String clientHashCode;

    private String authenticationToken;

    static ClientConfiguration toDomain(ClientConfigurationEntity entity) {
        return ClientConfiguration.builder()
                .withId(entity.id)
                .withVersion(entity.version)
                .withLocationId(entity.locationId)
                .withClientName(entity.clientName)
                .withClientHashCode(entity.clientHashCode)
                .withAuthenticationToken(entity.authenticationToken)
                .build();
    }

    static ClientConfigurationEntity toEntity(ClientConfiguration domain) {
        return new ClientConfigurationEntity(
                domain.getId(),
                domain.getVersion(),
                domain.getLocationId(),
                domain.getClientName(),
                domain.getClientHashCode(),
                domain.getAuthenticationToken()
        );
    }
}
