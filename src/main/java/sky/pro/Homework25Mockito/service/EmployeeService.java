package sky.pro.Homework25Mockito.service;

import sky.pro.Homework25Mockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}


//public static Employee[] employees = new Employee[10];


// public static void main(String[] args) {


// System.out.println("Coursework_1");
//employees[0] = new Employee(1,"Иванов", "Иван");
// employees[1] = new Employee(2,"Петров", "Пётр");
// employees[2] = new Employee(3,"Васичкин", "Василий");
//  employees[3] = new Employee(4,"Светина", "Светлана");
// employees[4] = new Employee(5,"Кукушкина", "Кукушка");
// employees[5] = new Employee(6,"Дроздов", "Дрозд");
// employees[6] = new Employee(7,"Свиридов", "Свирид");
// employees[7] = new Employee(8,"Хомячков", "Хомяк");
// employees[8] = new Employee(9,"Зябликов", "Зяблик");
//  employees[9] = new Employee(10,"Крендель", "Крендель");
//  printAll();
// System.out.println(getIdCounter());
//}

// int idCounter = getIdCounter();


//private static void printAll() {
//  for (int i = 0; i < EmployeeService.employees.length; i++) {
//     System.out.println(EmployeeService.employees[i]);

//}
//System.out.println("В фирме работает  сотрудников");

//}


