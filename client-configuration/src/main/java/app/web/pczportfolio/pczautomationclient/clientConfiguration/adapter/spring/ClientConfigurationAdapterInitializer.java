package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.spring;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseCreate;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class ClientConfigurationAdapterInitializer {
    private final ClientConfigurationUseCaseCreate configurationUseCaseCreate;

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)
    void init() {
        configurationUseCaseCreate.createClientConfigurationIfNotExists();
    }
}
