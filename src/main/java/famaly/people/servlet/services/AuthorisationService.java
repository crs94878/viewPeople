package famaly.people.servlet.services;

import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.request.user.credentials.Credentials;

public interface AuthorisationService {
    AuthSession authorisation(Credentials credentials);
}
