package tech.reliab.course.nikolotovai.bank.service;

import tech.reliab.course.nikolotovai.bank.entity.PaymentAccount;

public interface PaymentAccountService {
  PaymentAccount create(PaymentAccount paymentAccount);
  boolean depositMoney(PaymentAccount account, double amount);
  boolean withdrawMoney(PaymentAccount account, double amount);
}
