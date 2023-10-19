package tech.reliab.course.nikolotovai.bank.service.impl;

import tech.reliab.course.nikolotovai.bank.entity.BankOffice;
import tech.reliab.course.nikolotovai.bank.entity.Employee;
import tech.reliab.course.nikolotovai.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
  public Employee create(Employee employee) {
    if (employee == null) {
      return null;
    }

    if (employee.getId() < 0) {
      System.out.println("Error: id must be non-negative");
      return null;
    }

    if (employee.getSalary() < 0) {
      System.out.println("Error: salary must be non-negative");
      return null;
    }

    // Добавить проверку на офис и добавление в офис

    return new Employee(employee);
  }

  public boolean transferEmployee(Employee employee, BankOffice bankOffice) {
    // написать перевод сотрудника в новый офис когда будут массивы офисов и тд

    return true;
  }
}
