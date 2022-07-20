package app.web.pczportfolio.pczautomationclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
class HttpServletRequestConfiguration {
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
