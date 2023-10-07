package reliab.course.nikolotovai.bank;

import java.time.LocalDate;
import java.util.Locale;
import reliab.course.nikolotovai.bank.entity.Bank;
import reliab.course.nikolotovai.bank.entity.BankAtm;
import reliab.course.nikolotovai.bank.entity.BankOffice;
import reliab.course.nikolotovai.bank.entity.CreditAccount;
import reliab.course.nikolotovai.bank.entity.Employee;
import reliab.course.nikolotovai.bank.entity.PaymentAccount;
import reliab.course.nikolotovai.bank.entity.User;
import reliab.course.nikolotovai.bank.service.AtmService;
import reliab.course.nikolotovai.bank.service.BankOfficeService;
import reliab.course.nikolotovai.bank.service.BankService;
import reliab.course.nikolotovai.bank.service.CreditAccountService;
import reliab.course.nikolotovai.bank.service.EmployeeService;
import reliab.course.nikolotovai.bank.service.PaymentAccountService;
import reliab.course.nikolotovai.bank.service.UserService;
import reliab.course.nikolotovai.bank.service.impl.AtmServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.BankOfficeServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.BankServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.CreditAccountServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.EmployeeServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.PaymentAccountServiceImpl;
import reliab.course.nikolotovai.bank.service.impl.UserServiceImpl;
import reliab.course.nikolotovai.bank.utils.BankAtmStatus;


public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    BankService bankService = new BankServiceImpl();
    Bank bank = bankService.create(new Bank("Nikolotov Bank"));
    System.out.println(bank);

    BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    BankOffice bankOffice = bankOfficeService.create(new BankOffice(
      "Main office of Nikolotov Bank", 
      "Belgorod, Pushkina st., 1", 
      bank, 
      true, 
      true,
      0,
      true,
      true,
      true,
      bank.getTotalMoney(),
      950
    ));
    System.out.println(bankOffice);

    EmployeeService employeeService = new EmployeeServiceImpl();
    Employee employee = employeeService.create(new Employee("Aleksandr", LocalDate.of(2002, 7, 21), "CEO", bank, true, bankOffice, true, 1));
    System.out.println(employee);

    AtmService atmService = new AtmServiceImpl();
    BankAtm bankAtm = atmService.create(new BankAtm("Atm1", bankOffice.getAddress(), BankAtmStatus.WORKING, bank, bankOffice, employee, true, true, 0, 25));
    System.out.println(bankAtm);

    UserService userService = new UserServiceImpl();
    User user = userService.create(new User("Luna", LocalDate.of(1999, 1, 15), "Google", 3000.0, bank, 10000));
    System.out.println(user);

    PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(user, bank, 500));
    System.out.println(paymentAccount);

    CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank, LocalDate.of(2022, 1, 1), LocalDate.of(2025, 1, 1), 36, 3600, 3600, 100, 5, employee, paymentAccount));
    System.out.println(creditAccount);
  }
}