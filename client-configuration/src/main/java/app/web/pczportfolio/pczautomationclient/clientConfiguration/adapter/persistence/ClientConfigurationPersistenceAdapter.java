package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.persistence;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortConfigurationExists;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ClientConfigurationPersistenceAdapter implements
        ClientConfigurationPortSave,
        ClientConfigurationPortFindExisting {
    private final ClientConfigurationEntityJpaRepository jpaRepository;

    @Override
    public ClientConfiguration save(ClientConfiguration clientConfiguration) {
        final var entityToSave = ClientConfigurationEntity.toEntity(clientConfiguration);
        return ClientConfigurationEntity.toDomain(jpaRepository.save(entityToSave));
    }
}
