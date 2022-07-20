package app.web.pczportfolio.pczautomationclient.configuration.security.userDetailService;

import app.web.pczportfolio.pczautomationclient.clientConfiguration.exception.InvalidUsernameOrPasswordException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
@AllArgsConstructor
class UserDetailsServiceImpl implements UserDetailsService {
    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    private final UserDetailsServiceAuthorizationRequest userDetailsServiceAuthorizationRequest;
    private final HttpServletRequest httpServletRequest;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String authorizationHeader = fetchAuthorizationHeader();
        return userDetailsServiceAuthorizationRequest.authorizeUserByHeader(authorizationHeader)
                .orElseThrow(InvalidUsernameOrPasswordException::new);
    }

    String fetchAuthorizationHeader() {
        return Optional.ofNullable(httpServletRequest.getHeader(AUTHORIZATION_HEADER_NAME))
                .orElseThrow(InvalidUsernameOrPasswordException::new);
    }
}
