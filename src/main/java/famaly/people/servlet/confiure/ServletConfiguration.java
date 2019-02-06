package famaly.people.servlet.confiure;

import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.services.AuthorisationService;
import famaly.people.servlet.services.AuthorisationUserSession;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
public class ServletConfiguration {

    @Bean
    @Lazy
    public AuthorisationUserSession authorisationUserSession(){
        return  new AuthorisationUserSession();
    }

    @Bean
    @Lazy
    public AuthorisationService authorisationService(AuthorisationUserSession authorisationUserSession){
        return authorisationUserSession;
    }

    @Bean
    public RestTemplate restTemplate(){
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    @Lazy
    @Scope(scopeName = "prototype")
    public AuthSession authSession(){
        return new AuthSession();
    }
}
