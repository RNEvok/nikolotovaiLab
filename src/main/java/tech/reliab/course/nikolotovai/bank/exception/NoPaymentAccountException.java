package tech.reliab.course.nikolotovai.bank.exception;

public class NoPaymentAccountException extends Exception {
  public NoPaymentAccountException() {
		super("Error: no payment accounts found.");
	}
}