package sky.pro.Homework25Mockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CheckSalaryException extends IllegalArgumentException{
    private  CheckSalaryException(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть меньше нуля");
        }
       // return salary;
    }
}
