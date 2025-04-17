package be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user;

import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserBadCredentialsException extends BaseException {
    public UserBadCredentialsException(HttpStatus status, Object error) {
        super(status, error);
    }
}
