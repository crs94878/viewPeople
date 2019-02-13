package famaly.people.servlet.services;

import famaly.people.servlet.models.request.user.credentials.SessionCookies;
import famaly.people.servlet.models.response.front.AuthSession;
import famaly.people.servlet.models.response.front.SessionValidationResponse;

public interface ValidationService {
    SessionValidationResponse validationSession(SessionCookies cookies);
}
