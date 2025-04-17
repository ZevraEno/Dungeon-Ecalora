package be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user;

import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class PseudonymFoundException extends BaseException {
    public PseudonymFoundException(HttpStatus status, String error) {
        super(status, error);
    }
}
