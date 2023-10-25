package tech.reliab.course.nikolotovai.bank.service;

import java.util.List;

import tech.reliab.course.nikolotovai.bank.entity.Bank;
import tech.reliab.course.nikolotovai.bank.entity.BankOffice;
import tech.reliab.course.nikolotovai.bank.entity.CreditAccount;
import tech.reliab.course.nikolotovai.bank.entity.Employee;
import tech.reliab.course.nikolotovai.bank.entity.User;

public interface BankService {
  // Создание банка
  public Bank create(Bank bank);
  public void pringBankData(int id);
  // Получение банка по id
  public Bank getBankById(int id);
  // Удаление банка по id
  public boolean deleteBankById(int id);
  // Получение всех банков
  public List<Bank> getAllBanks();
  // Добавление офиса
  public boolean addOffice(int bankId, BankOffice bankOffice);
  // Удаление офиса
  public boolean removeOffice(int bankId, BankOffice bankOffice);
  // Добавление сотрудника
  public boolean addEmployee(Bank bank, Employee employee);
  // Удаление сотрудника
  public boolean removeEmployee(Bank bank, Employee employee);
  // Добавление клиента
  public boolean addClient(Bank bank, User user);
  // Удаление клиента
  public boolean removeClient(Bank bank, User user);
  // Вычисление процентной ставки банка (чем выше рейтинг, тем ниже ставка).
  public double calculateInterestRate(Bank bank);
  /*
  Внести сумму денег sum в банк bank.
  */
  public boolean depositMoney(int bankId, double amount);
  /*
  Вывести деньги sum из банка bank.
  */
  public boolean withdrawMoney(Bank bank, double amount);
  /*
  Оформление заявки на кредит.
  В операции может быть отказано, если в банке недостаточно денег / сотрудник employee не выдает кредиты /
  доход клиента меньше, чем ежемесячная выплата по кредиту
  */
  public boolean approveCredit(Bank bank, CreditAccount account, Employee employee);
}