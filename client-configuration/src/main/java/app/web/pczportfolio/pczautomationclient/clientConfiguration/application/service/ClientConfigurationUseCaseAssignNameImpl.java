package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseAssignName;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class ClientConfigurationUseCaseAssignNameImpl implements ClientConfigurationUseCaseAssignName {
    private final ClientConfigurationProviderService configurationProviderService;
    private final ClientConfigurationPortSave configurationPortSave;

    @Override
    @Transactional
    public ClientConfiguration assignName(String name) {
        ClientConfiguration configuration = configurationProviderService.getConfigurationOrCreateIfNotExists();
        configuration.assignName(name);
        configurationPortSave.save(configuration);
        return configuration;
    }
}
