package reliab.course.nikolotovai.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditAccount extends Account {
  private LocalDate dateStart;
  private LocalDate dateEnd;
  private int monthCount;
  private double creditAmount;
  private double monthlyPayment;
  private double interestRate;
  private Employee employee;
  private PaymentAccount paymentAccount;

  private void initializeWithDefaults() {
    dateStart = null;
    dateEnd = null;
    monthCount = 0;
    creditAmount = 0;
    monthlyPayment = 0;
    interestRate = 0;
    employee = null;
    paymentAccount = null;
  }

  public CreditAccount() {
    super();
    initializeWithDefaults();
  }

  public CreditAccount(LocalDate dateStart, LocalDate dateEnd, int monthCount, double creditAmount, double monthlyPayment, double interestRate, Employee employee, PaymentAccount paymentAccount) {
    super();
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.monthCount = monthCount;
    this.creditAmount = creditAmount;
    this.monthlyPayment = monthlyPayment;
    this.interestRate = interestRate;
    this.employee = employee;
    this.paymentAccount = paymentAccount;
  }

  public CreditAccount(int id, User user, Bank bank, LocalDate dateStart, LocalDate dateEnd, int monthCount, double creditAmount, double monthlyPayment, double interestRate, Employee employee, PaymentAccount paymentAccount) {
    super(id, user, bank);
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.monthCount = monthCount;
    this.creditAmount = creditAmount;
    this.monthlyPayment = monthlyPayment;
    this.interestRate = interestRate;
    this.employee = employee;
    this.paymentAccount = paymentAccount;
  }

  @Override
  public String toString() {
    return 
      "\n{\n" +
      "\tid: " + id + ",\n" +
      "\tuser: " + (user == null ? "null" : user.getName()) + ",\n" +
      "\tbank: " + (bank == null ? "null" : bank.getName()) + ",\n" +
      "\tdateStart: " + (dateStart == null ? "null" : dateStart.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))) + ",\n" +
      "\tdateEnd: " + (dateEnd == null ? "null" : dateEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))) + ",\n" +
      "\tmonthCount: " + monthCount + ",\n" +
      "\tcreditAmount: " + String.format("%.2f", creditAmount) + ",\n" +
      "\tmonthlyPayment: " + String.format("%.2f", monthlyPayment) + ",\n" +
      "\tinterestRate: " + String.format("%.2f", interestRate) + ",\n" +
      "\temployee: " + (employee == null ? "null" : employee.getName()) + ",\n" +
      "\tpaymentAccount: " + (paymentAccount == null ? "null" : paymentAccount.getId()) + ",\n" +
      "}\n";
  }
}
