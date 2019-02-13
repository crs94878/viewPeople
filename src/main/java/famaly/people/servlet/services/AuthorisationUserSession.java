package famaly.people.servlet.services;

import famaly.people.servlet.models.request.user.credentials.SessionCookies;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;
import famaly.people.servlet.models.response.front.SessionValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AuthorisationUserSession implements AuthorisationService, ValidationService {


    private AuthSession session;

    private SessionValidationResponse sessionValidationResponse;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth.api.url}")
    private String authApiUrl;

    @Value("${validation.api.url}")
    private String validationApiUrl;

    @Override
    public AuthSession authorisation(Credentials credentials) {
        HttpEntity<Credentials> requestEnity = new HttpEntity<>(credentials);
        session = restTemplate.postForObject(authApiUrl,requestEnity, AuthSession.class);
        return session;
    }

    @Override
    public SessionValidationResponse validationSession(SessionCookies cookies) {
        HttpEntity<SessionCookies> requestValidation = new HttpEntity<>(cookies);
        sessionValidationResponse = restTemplate.postForObject(validationApiUrl, requestValidation, SessionValidationResponse.class);
        return sessionValidationResponse;
    }
}
