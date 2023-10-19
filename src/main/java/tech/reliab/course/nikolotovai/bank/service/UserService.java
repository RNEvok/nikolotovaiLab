package tech.reliab.course.nikolotovai.bank.service;

import tech.reliab.course.nikolotovai.bank.entity.User;

public interface UserService {
  User create(User user);
  int calculateCreditRating(User user);
}
