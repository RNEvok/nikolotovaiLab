package tech.reliab.course.nikolotovai.bank.exception;

public class CreditException extends RuntimeException {
	public CreditException(String reason) {
		super("Error: credit can not be approven - " + reason);
	}
}