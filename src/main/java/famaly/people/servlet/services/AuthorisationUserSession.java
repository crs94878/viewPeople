package famaly.people.servlet.services;

import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AuthorisationUserSession implements AuthorisationService {


    private AuthSession session;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth.api.url}")
    private String authApiUrl;

    @Override
    public AuthSession authorisation(Credentials credentials) {
        HttpEntity<Credentials> requestEnity = new HttpEntity<>(credentials);
        session = restTemplate.postForObject(authApiUrl,requestEnity, AuthSession.class);
        return session;
    }
}
