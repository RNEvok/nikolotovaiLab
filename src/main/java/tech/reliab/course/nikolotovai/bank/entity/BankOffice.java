package reliab.course.nikolotovai.bank.entity;

public class BankOffice {
  private int id;
  private String name;
  private String address;
  private boolean isWorking;
  private boolean isAtmPlaceable;
  private int atmCount;
  private boolean isCreditAvailable;
  private boolean isCashWithdrawalAvailable;
  private boolean isCashDepositAvailable;
  private double totalMoney;
  private double rentPrice;

  private void initializeWithDefaults() {
    id = -1;
    name = "No name";
    address = "No address";
    isWorking = false;
    isAtmPlaceable = false;
    atmCount = 0;
    isCreditAvailable = false;
    isCashWithdrawalAvailable = false;
    isCashDepositAvailable = false;
    totalMoney = 0;
    rentPrice = 0;
  }

  public BankOffice() {
    initializeWithDefaults();
  }

  public BankOffice(int id, String name, String address) {
    initializeWithDefaults();
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public BankOffice(int id, String name, String address, boolean isWorking, boolean isAtmPlaceable, int atmCount, boolean isCreditAvailable, boolean isCashWithdrawalAvailable, boolean isCashDepositAvailable, double totalMoney, double rentPrice) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.isWorking = isWorking;
    this.isAtmPlaceable = isAtmPlaceable;
    this.atmCount = atmCount;
    this.isCreditAvailable = isCreditAvailable;
    this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
    this.isCashDepositAvailable = isCashDepositAvailable;
    this.totalMoney = totalMoney;
    this.rentPrice = rentPrice;
  }
}
