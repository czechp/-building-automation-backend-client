package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseAssignName;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationUseCaseAssignNameImplTest {
    @Mock
    ClientConfigurationProviderService configurationProviderService;
    @Mock
    ClientConfigurationPortSave configurationPortSave;

    ClientConfigurationUseCaseAssignName configurationUseCaseAssignName;

    @BeforeEach
    void init() {
        this.configurationUseCaseAssignName = new ClientConfigurationUseCaseAssignNameImpl(
                configurationProviderService,
                configurationPortSave
        );
    }

    @Test
    void assignNameTest() {
        //given
        final var newClientName = "New name for client";
        final var fetchedConfiguration = ClientConfiguration.builder().build();
        //when
        when(configurationProviderService.getConfigurationOrCreateIfNotExists()).thenReturn(fetchedConfiguration);
        final var configurationWithNewName = configurationUseCaseAssignName.assignName(newClientName);
        //then
        verify(configurationPortSave, times(1)).save(any());
        assertEquals(newClientName, configurationWithNewName.getClientName());
    }
}