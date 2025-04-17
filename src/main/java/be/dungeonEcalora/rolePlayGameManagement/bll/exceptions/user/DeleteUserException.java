package be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user;

import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class DeleteUserException extends BaseException {

    public DeleteUserException(HttpStatus status, Object error) {
        super(status, error);
    }
}
