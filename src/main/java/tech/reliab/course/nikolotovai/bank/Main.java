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
import reliab.course.nikolotovai.bank.service.BankService;
import reliab.course.nikolotovai.bank.service.impl.BankServiceImpl;
import reliab.course.nikolotovai.bank.utils.BankAtmStatus;


public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    // System.out.println("Hello world!");
    BankService bankService = new BankServiceImpl();
    Bank bank = new Bank(10, "hehe");
    BankOffice bankOffice = new BankOffice(1, "office1", "pushkina");
    Employee employee = new Employee(1, "Alex", LocalDate.of(1999, 7, 25), "CEO", bank, true, bankOffice, true, 1000);  
    BankAtm bankAtm = new BankAtm(1, "Atm1", "pushkina", BankAtmStatus.WORKING, bank, bankOffice, employee, true, true, 5000, 25);
    User user = new User(2, "Luna", LocalDate.of(1998, 1, 15), "Google", 3000.0, bank, 10000);
    PaymentAccount paymentAccount = new PaymentAccount(1, user, bank, 500);
    CreditAccount creditAccount = new CreditAccount(2, user, bank, LocalDate.of(2022, 1, 1), LocalDate.of(2025, 1, 1), 36, 3600, 100, 5, employee, paymentAccount);
    
    System.out.println(creditAccount.toString());
  }
}