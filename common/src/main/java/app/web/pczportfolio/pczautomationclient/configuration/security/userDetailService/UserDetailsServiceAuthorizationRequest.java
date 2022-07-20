package app.web.pczportfolio.pczautomationclient.configuration.security.userDetailService;

import java.util.Optional;

interface UserDetailsServiceAuthorizationRequest {
    Optional<UserDetailsDto> authorizeUserByHeader(String authorizationHeader);
}
