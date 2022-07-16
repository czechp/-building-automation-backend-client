package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortFindExisting;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseCreate;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class ClientConfigurationUseCaseCreateImpl implements ClientConfigurationUseCaseCreate {
    private final ClientConfigurationPortFindExisting configurationPortFindExisting;
    private final ClientConfigurationPortSave configurationPortSave;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ClientConfiguration createClientConfigurationIfNotExists() {
        return configurationPortFindExisting.findExistingConfiguration()
                .orElseGet(() -> configurationPortSave.save(new ClientConfiguration()));
    }
}
