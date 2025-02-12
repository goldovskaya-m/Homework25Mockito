package sky.pro.Homework25Mockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNameException extends IllegalArgumentException{
    public InvalidNameException(String name) {
        super("Invalid name" + name);
    }
}
