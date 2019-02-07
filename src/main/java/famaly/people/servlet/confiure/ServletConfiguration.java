package famaly.people.servlet.confiure;

import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.services.AuthorisationService;
import famaly.people.servlet.services.AuthorisationUserSession;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
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
        return new RestTemplate();
    }

}
