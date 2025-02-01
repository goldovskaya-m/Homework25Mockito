package sky.pro.Homework25Mockito.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sky.pro.Homework25Mockito.exception.EmployeeAlreadyAddedException;
import sky.pro.Homework25Mockito.exception.EmployeeNotFoundException;
import sky.pro.Homework25Mockito.model.Employee;

import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
import static sky.pro.Homework25Mockito.TestAssistant.*;

class EmployeeServiceImplTest {
    

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @DisplayName("Положительный тест, что  сотрудник успешно добавлен, " +
            "в том случае, если он отсутствовал в списке")
    @Test
    void add() {
        
        Employee actual = employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME);

        assertThat(actual).isNotNull();
        assertThat(actual.getFirstName()).isEqualTo(TEST_FIRSTNAME);
        assertThat(actual.getLastName()).isEqualTo(TEST_LASTNAME);
    }

    @DisplayName("Положительный тест, что  сотрудник id и его зп успешно добавлены, " +
            "в том случае, если он отсутствовал в списке")
    @Test
    void add2() {
        Employee actual = employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);

        assertThat(actual).isNotNull();
        assertThat(actual.getFirstName()).isEqualTo(TEST_FIRSTNAME);
        assertThat(actual.getLastName()).isEqualTo(TEST_LASTNAME);
        assertThat(actual.getDepartmentId()).isEqualTo(TEST_DEPARTMENT_ID);
        assertThat(actual.getSalary()).isEqualTo(TEST_SALARY);
    }

    @DisplayName("Негативный тест на повторное добавление сотрудника," +
            " выбрасывается исключение Exception- уже добавлен")
    @Test
    void add3() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";

        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME));
    }


    @DisplayName("Негативный тест на повторное добавление сотрудника," +
            " выбрасывается исключение Exception - уже добавлен")
    @Test
    void add4() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";
        int TEST_DEPARTMENT_ID = 66;
        double TEST_SALARY = 7;


        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY));
    }


    @DisplayName("Положительный тест, что добавленный сотрудник успешро удалён")
    @Test
    void remove() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";

        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME);

        employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME);
        Collection<Employee> all = employeeService.findAll();
        assertThat(all).isEmpty();
       
    }

    @DisplayName("Положительный тест, что добавленный сотрудник  id  и зарплата успешро удалён")
    @Test
    void remove2() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";
        int TEST_DEPARTMENT_ID = 7;
        double TEST_SALARY = 9;


        Employee actual = employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);

        employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);
        Collection<Employee> all = employeeService.findAll();
        assertThat(all).isEmpty();

    }

    @DisplayName("Негативный тест, выбрасывается исключение Exception - Такой сотрудник не найден")
    @Test
    void remove3() {

        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";
        int TEST_DEPARTMENT_ID = 65;
        double TEST_SALARY = 88;
        
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY));
    }

    @DisplayName("Негативный тест, выбрасывается исключение Exception - Такой сотрудник не найден")
    @Test
    void remove4() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";

        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME);

        employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME);
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME));
    }

    @DisplayName("Положительный тест, сотрудник найден")
    @Test
    void find() {

        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";
        int TEST_DEPARTMENT_ID = 8;
        double TEST_SALARY = 7;

        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);

        employeeService.find(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);
        Collection<Employee> all = employeeService.findAll();
    }

    @DisplayName("Негативный тест, выбрасывается исключение Exception - Такой сотрудник не найден")
    @Test
    void find2() {
        String TEST_LASTNAME = "Фамилия";
        String TEST_FIRSTNAME = "Имя";
        int TEST_DEPARTMENT_ID = 8;
        double TEST_SALARY = 4;

        employeeService.add(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);

        employeeService.remove(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY);
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.find(TEST_FIRSTNAME, TEST_LASTNAME, TEST_DEPARTMENT_ID, TEST_SALARY));

    }

}
