package tech.reliab.course.nikolotovai.bank;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static tech.reliab.course.nikolotovai.bank.utils.Constants.*;

import tech.reliab.course.nikolotovai.bank.entity.Bank;
import tech.reliab.course.nikolotovai.bank.entity.BankAtm;
import tech.reliab.course.nikolotovai.bank.entity.BankOffice;
// import tech.reliab.course.nikolotovai.bank.entity.CreditAccount;
import tech.reliab.course.nikolotovai.bank.entity.Employee;
// import tech.reliab.course.nikolotovai.bank.entity.PaymentAccount;
import tech.reliab.course.nikolotovai.bank.entity.User;
import tech.reliab.course.nikolotovai.bank.service.AtmService;
import tech.reliab.course.nikolotovai.bank.service.BankOfficeService;
import tech.reliab.course.nikolotovai.bank.service.BankService;
// import tech.reliab.course.nikolotovai.bank.service.CreditAccountService;
import tech.reliab.course.nikolotovai.bank.service.EmployeeService;
// import tech.reliab.course.nikolotovai.bank.service.PaymentAccountService;
import tech.reliab.course.nikolotovai.bank.service.UserService;
import tech.reliab.course.nikolotovai.bank.service.impl.AtmServiceImpl;
import tech.reliab.course.nikolotovai.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.nikolotovai.bank.service.impl.BankServiceImpl;
// import tech.reliab.course.nikolotovai.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.nikolotovai.bank.service.impl.EmployeeServiceImpl;
// import tech.reliab.course.nikolotovai.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.nikolotovai.bank.service.impl.UserServiceImpl;
import tech.reliab.course.nikolotovai.bank.utils.BankAtmStatus;
import tech.reliab.course.nikolotovai.bank.utils.Constants;


public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Random random = new Random();
    new Constants();
    Scanner scanner = new Scanner(System.in);

    // Создание сервисов
    BankService bankService = new BankServiceImpl();
    BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
    bankService.setBankOfficeService(bankOfficeService);
    EmployeeService employeeService = new EmployeeServiceImpl(bankOfficeService);
    AtmService atmService = new AtmServiceImpl(bankOfficeService);
    UserService userService = new UserServiceImpl(bankService);
    bankService.setUserService(userService);
    // PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    // CreditAccountService creditAccountService = new CreditAccountServiceImpl();

    // Создание банков
    bankService.create(new Bank("Nikolotov Bank"));
    // System.out.println(bank);

    // Создание офисов в каждом банке
    List<Bank> banks = bankService.getAllBanks();
    for (Bank bank : banks) {
      for (int i = 1; i <= 3; i++) {
        bankOfficeService.create(new BankOffice(
          "Office #" + String.valueOf(i) + " of " + bank.getName(), 
          "Belgorod, Pushkina st., " + String.valueOf(i), 
          bank, 
          true, 
          true,
          0,
          true,
          true,
          true,
          10000,
          100 * i
        ));
      }
    }

    // Добавление сотрудников в каждый офис
    List<BankOffice> offices = bankOfficeService.getAllOffices();
    for (BankOffice office : offices) {
      for (int i = 1; i <= 5; i++) {
        employeeService.create(new Employee(
          HUMAN_NAMES.get(random.nextInt(HUMAN_NAMES.size())), 
          LocalDate.of(random.nextInt(1990, 2003), random.nextInt(1, 13), random.nextInt(1, 29)), 
          BANK_ROLES.get(random.nextInt(BANK_ROLES.size())), 
          office.getBank(), 
          true,
          office,
          true,
          500
        ));
      }
    }

    // Добавление банкоматов в каждый офис
    for (BankOffice office : offices) {
      for (int i = 1; i <= 3; i++) {
        atmService.create(new BankAtm(
          "Atm " + String.valueOf(i), 
          office.getAddress(), 
          BankAtmStatus.WORKING, 
          office.getBank(), 
          office, 
          bankOfficeService.getAllEmployeesByOfficeId(office.getId()).get(random.nextInt(bankOfficeService.getAllEmployeesByOfficeId(office.getId()).size())), 
          true, 
          true, 
          0, 
          random.nextDouble() * 25
        ));
      }
    }

    // Добавление клиентов в каждый банк
    for (Bank bank : banks) {
      for (int i = 1; i <= 5; i++) {
        userService.create(
          new User(
            HUMAN_NAMES.get(random.nextInt(HUMAN_NAMES.size())), 
            LocalDate.of(random.nextInt(1940, 2003), random.nextInt(1, 13), random.nextInt(1, 29)), 
            COMPANY_NAMES.get(random.nextInt(COMPANY_NAMES.size())), 
            random.nextDouble() * 10000, 
            bank, 
            random.nextInt(10000)
          ));
      }
    }

    // PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(user, bank, 500));
    // // System.out.println(paymentAccount);

    // CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank, LocalDate.of(2022, 1, 1), LocalDate.of(2025, 1, 1), 36, 3600, 3600, 100, 5, employee, paymentAccount));

    System.out.println("\nWelcome to lab2.");
    System.out.println("Number of banks in system: " + bankService.getAllBanks().size());
    for (Bank bank : bankService.getAllBanks()) {
      System.out.println("id: " + bank.getId() + " - " + bank.getName());
    }

    while (true) {
      System.out.println("\nChoose an action: ");
      System.out.println("b - check bank data by bank id");
      System.out.println("u - check user data by user id");
      System.out.println("q - quit program");

      String action = scanner.nextLine();

      if (action.equals("b")) {
        System.out.println("Enter bank id:");
        int bankIdToPrint = scanner.nextInt();
        scanner.nextLine();
        bankService.printBankData(bankIdToPrint);
      } else if (action.equals("u")) {
        System.out.println("Enter user id:");
      } else if (action.equals("q")) {
        break;
      } else {
        System.out.println("Error: unknown action. Please, try again");
      }
    }
  }
}