package famaly.people.servlet.models;

import java.util.Date;

public class AuthSession {
    private String sessionId;
    private String userName;
    private String tokenStr;
    private boolean validation;
    private Date dateAuth;
}
