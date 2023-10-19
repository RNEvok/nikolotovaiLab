package tech.reliab.course.nikolotovai.bank.service;

import tech.reliab.course.nikolotovai.bank.entity.CreditAccount;

public interface CreditAccountService {
  CreditAccount create(CreditAccount creditAccount);
  boolean makeMonthlyPayment(CreditAccount account);
}
