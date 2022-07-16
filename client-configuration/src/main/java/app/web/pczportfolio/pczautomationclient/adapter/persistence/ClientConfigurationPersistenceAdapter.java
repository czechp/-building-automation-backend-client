package app.web.pczportfolio.pczautomationclient.adapter.persistence;

import app.web.pczportfolio.pczautomationclient.application.port.ClientConfigurationPortConfigurationExists;
import app.web.pczportfolio.pczautomationclient.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ClientConfigurationPersistenceAdapter implements ClientConfigurationPortConfigurationExists {
    private final ClientConfigurationEntityJpaRepository jpaRepository;

    @Override
    public boolean configurationExists() {
        return jpaRepository.configurationExists();
    }
}
