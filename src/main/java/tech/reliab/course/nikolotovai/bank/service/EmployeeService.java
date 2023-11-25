package tech.reliab.course.nikolotovai.bank.service;

import java.util.List;

import tech.reliab.course.nikolotovai.bank.entity.Employee;
import tech.reliab.course.nikolotovai.bank.exception.UniquenessException;

public interface EmployeeService {
  Employee create(Employee employee) throws UniquenessException;
  public Employee getEmployeeById(int id);
  public List<Employee> getAllEmployees();
  public boolean isEmployeeSuitable(Employee employee);
}