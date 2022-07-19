package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.rest;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.dto.ClientConfigurationLoginDto;
import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseSetAuthorizationToken;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/configuration/login")
@CrossOrigin("*")
@AllArgsConstructor
class ClientConfigurationRestAdapterSetAuthorizationToken {
    private final ClientConfigurationUseCaseSetAuthorizationToken configurationUseCaseSetAuthorizationToken;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void authenticateUser(@RequestBody @Valid ClientConfigurationLoginDto loginDto) {
        configurationUseCaseSetAuthorizationToken.assignAuthorizationToken(loginDto);
    }
}
