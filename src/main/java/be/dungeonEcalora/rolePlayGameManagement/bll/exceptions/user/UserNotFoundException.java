package be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.user;

import be.dungeonEcalora.rolePlayGameManagement.bll.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
  public UserNotFoundException(HttpStatus status, String error) {
    super(status, error);
  }
}
