package famaly.people.servlet.models.response.front;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AuthSession {
    private String sessionId;
    private String userName;
    private String tokenStr;
    private boolean validation;
    private XMLGregorianCalendar dateAuth;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public XMLGregorianCalendar getDateAuth() {
        return dateAuth;
    }

    public void setDateAuth(XMLGregorianCalendar dateAuth) {
        this.dateAuth = dateAuth;
    }
}
