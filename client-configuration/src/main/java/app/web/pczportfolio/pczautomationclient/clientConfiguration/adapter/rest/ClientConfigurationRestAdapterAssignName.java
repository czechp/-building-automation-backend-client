package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.rest;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.application.useCase.ClientConfigurationUseCaseAssignName;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/configuration/name")
@CrossOrigin("*")
@AllArgsConstructor
@Validated
class ClientConfigurationRestAdapterAssignName {
    private final ClientConfigurationUseCaseAssignName configurationUseCaseAssignName;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void assignClientNewName(@RequestParam(name = "name")
                             @Length(min = 5, message = "Name has to have minimum 5 characters") String newClientName
    ) {
        configurationUseCaseAssignName.assignName(newClientName);
    }
}
