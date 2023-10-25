package tech.reliab.course.nikolotovai.bank.service;

import java.util.List;

import tech.reliab.course.nikolotovai.bank.entity.User;

public interface UserService {
  User create(User user);
  public void printUserData(int id);
  public User getUserById(int id);
  public List<User> getAllUsers();
  int calculateCreditRating(User user);
}
