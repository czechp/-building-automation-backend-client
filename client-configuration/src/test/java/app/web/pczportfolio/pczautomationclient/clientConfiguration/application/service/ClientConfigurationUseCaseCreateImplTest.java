package app.web.pczportfolio.pczautomationclient.clientConfiguration.application.service;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortFindExisting;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.port.ClientConfigurationPortSave;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseCreate;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.domain.ClientConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationUseCaseCreateImplTest {
    @Mock
    ClientConfigurationPortFindExisting configurationPortFindExisting;
    @Mock
    ClientConfigurationPortSave configurationPortSave;

    ClientConfigurationUseCaseCreate configurationUseCaseCreate;

    @BeforeEach
    void init() {
        this.configurationUseCaseCreate = new ClientConfigurationUseCaseCreateImpl(configurationPortFindExisting, configurationPortSave);
    }


    @Test
    void createClientConfigurationIfNotExistsTest() {
        //given
        //when
        when(configurationPortFindExisting.findExistingConfiguration()).thenReturn(Optional.empty());
        when(configurationPortSave.save(any())).thenReturn(new ClientConfiguration());
        final var createdConfiguration = configurationUseCaseCreate.createClientConfigurationIfNotExists();
        //then
        verify(configurationPortSave, times(1)).save(any());
    }

    @Test
    void createClientConfigurationIfNotExistsAlreadyExistsTest() {
        //given
        final var existingConfiguration = new ClientConfiguration();
        //when
        when(configurationPortFindExisting.findExistingConfiguration()).thenReturn(Optional.of(existingConfiguration));
        final var createdConfiguration = configurationUseCaseCreate.createClientConfigurationIfNotExists();
        //then
        verify(configurationPortSave, times(0)).save(any());
    }
}