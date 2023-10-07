package reliab.course.nikolotovai.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends Human {
  private String placeOfWork;
  private double monthlyIncome;
  private Bank bank;
  private int creditRating;

  private void initializeWithDefaults() {
    placeOfWork = "";
    monthlyIncome = 0;
    bank = null;
    creditRating = 0;
  }

  public User() {
    super();
    initializeWithDefaults();
  }

  public User(String placeOfWork, double monthlyIncome, Bank bank, int creditRating) {
    super();
    this.placeOfWork = placeOfWork;
    this.monthlyIncome = monthlyIncome;
    this.bank = bank;
    this.creditRating = creditRating;
  }

  public User(int id, String name, LocalDate birthDate) {
    super(id, name, birthDate);
    initializeWithDefaults();
  }

  public User(int id, String name, LocalDate birthDate, String placeOfWork, double monthlyIncome, Bank bank, int creditRating) {
    super(id, name, birthDate);
    this.placeOfWork = placeOfWork;
    this.monthlyIncome = monthlyIncome;
    this.bank = bank;
    this.creditRating = creditRating;
  }

  @Override
  public String toString() {
    return 
      "\n{\n" +
      "\tid: " + id + ",\n" +
      "\tname: " + name + ",\n" +
      "\tbirthDate: " + (birthDate == null ? "null" : birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))) + ",\n" +
      "\tplaceOfWork: " + placeOfWork + ",\n" +
      "\tmonthlyIncome: " + String.format("%.2f", monthlyIncome) + ",\n" +
      "\tbank: " + (bank == null ? "null" : bank.getName()) + ",\n" +
      "\tcreditRating: " + creditRating + ",\n" +
      "}\n";
  }

  public void setPlaceOfWork(String placeOfWork) {
    this.placeOfWork = placeOfWork;
  }

  public String getPlaceOfWork() {
    return placeOfWork;
  }

  public void setMonthlyIncome(double monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  public double getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public Bank getBank() {
    return bank;
  }

  public void setCreditRating(int creditRating) {
    this.creditRating = creditRating;
  }

  public int getCreditRating() {
    return creditRating;
  }
}
