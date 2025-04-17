package be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user;


import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserEmailException extends BaseException {
    public UserEmailException(HttpStatus status, Object error) {
        super(status, error);
    }
}