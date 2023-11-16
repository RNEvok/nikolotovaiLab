package tech.reliab.course.nikolotovai.bank.exception;

public class BankFailureException extends Exception {
  public BankFailureException(String problem) {
		super("Error: bank critical failure: " + problem);
	}
}