package tech.reliab.course.nikolotovai.bank.exception;

public class PaymentException extends Exception {
  public PaymentException(String msg) {
		super("Error: can not " + msg + " - not enough balance.");
	}
}