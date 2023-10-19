package tech.reliab.course.nikolotovai.bank.service;

import tech.reliab.course.nikolotovai.bank.entity.BankOffice;
import tech.reliab.course.nikolotovai.bank.entity.Employee;

public interface EmployeeService {
  Employee create(Employee employee);
  boolean transferEmployee(Employee employee, BankOffice bankOffice);
}