package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortFindExisting;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class ClientConfigurationProviderService {
    private final ClientConfigurationPortFindExisting clientConfigurationPortFindExisting;
    private final ClientConfigurationPortSave configurationPortSave;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    ClientConfiguration getConfigurationOrCreateIfNotExists() {
        return clientConfigurationPortFindExisting.findExistingConfiguration()
                .orElseGet(() -> configurationPortSave.save(new ClientConfiguration()));
    }
}
