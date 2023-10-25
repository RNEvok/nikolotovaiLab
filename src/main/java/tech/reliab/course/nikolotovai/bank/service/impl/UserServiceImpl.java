package tech.reliab.course.nikolotovai.bank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static tech.reliab.course.nikolotovai.bank.utils.Constants.*;

import tech.reliab.course.nikolotovai.bank.entity.User;
import tech.reliab.course.nikolotovai.bank.service.BankService;
import tech.reliab.course.nikolotovai.bank.service.UserService;

public class UserServiceImpl implements UserService {
  private final Map<Integer, User> usersTable = new HashMap<>();
  private final BankService bankService;

  public UserServiceImpl(BankService bankService) {
    this.bankService = bankService;
  }

  public int calculateCreditRating(User user) {
    final int rating = (int)Math.ceil(user.getMonthlyIncome() / 1000) * 100;
    user.setCreditRating(rating);
    return rating;
  }

  public User create(User user) {
    if (user == null) {
      return null;
    }

    if (user.getId() < 0) {
      System.out.println("Error: user id must be non-negative");
      return null;
    }

    if (user.getBank() == null) {
      System.out.println("Error: can not create user without bank");
      return null;
    }

    User createdUser = new User(user);

    final Random random = new Random();

    final double monthlyIncome = random.nextDouble() * MAX_USER_MONTHLY_INCOME;
    createdUser.setMonthlyIncome(monthlyIncome);
    calculateCreditRating(createdUser);
    usersTable.put(createdUser.getId(), createdUser);
    bankService.addClient(user.getBank().getId(), user);

    return createdUser;
  }

  public void printUserData(int id) {
    User user = usersTable.get(id);

    if (user == null) {
      System.out.println("Клиент с id: " + id + " не был найден.");
      return;
    }

    System.out.println(user);
  }

  public User getUserById(int id) {
    User user = usersTable.get(id);

		if (user == null) {
			System.out.println("Клиент с id: " + id + " не был найден.");
		}

		return user;
  }

  public List<User> getAllUsers() {
    return new ArrayList<User>(usersTable.values());
  }
}