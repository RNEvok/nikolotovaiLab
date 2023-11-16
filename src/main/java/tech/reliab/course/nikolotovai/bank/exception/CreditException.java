package tech.reliab.course.nikolotovai.bank.exception;

public class CreditException extends Exception {
	public CreditException(String reason) {
		super("Error: credit can not be approven - " + reason);
	}
}