package sky.pro.Homework25Mockito;

import sky.pro.Homework25Mockito.model.Employee;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


public class TestAssistant {
    public static final String TEST_LASTNAME = "Фамилия";
    public static final String TEST_FIRSTNAME = "Имя";
    public static final int TEST_DEPARTMENT_ID = 56;
    public static final double TEST_SALARY = 4000;

    private static final Random RANDOM = new Random();

    public static Employee createEmployee(String lastName, String firstName, int departmentId, double salary) {
        return new Employee(lastName, firstName, departmentId, salary);
    }


    public static Employee createEmployee(double salary) {
        return createEmployee(RANDOM.nextInt(1, 1000), salary);
    }

    public static Employee createEmployee(int departmentId, double salary) {
        return createEmployee(randomAlphabetic(12),
                randomAlphabetic(12), departmentId, salary);

    }

    public static Employee createEmployee(int departmentId) {
        return createEmployee(randomAlphabetic(12),
                randomAlphabetic(12), departmentId, RANDOM.nextDouble(0, 200_000));


    }
}
