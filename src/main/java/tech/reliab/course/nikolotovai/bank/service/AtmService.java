package reliab.course.nikolotovai.bank.service;

import reliab.course.nikolotovai.bank.entity.BankAtm;

public interface AtmService {
  BankAtm create(BankAtm bankAtm);
  boolean depositMoney(BankAtm bankAtm, double amount);
  boolean withdrawMoney(BankAtm bankAtm, double amount);
}
