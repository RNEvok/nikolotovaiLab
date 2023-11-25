package tech.reliab.course.nikolotovai.bank.exception;

public class AccountTransferException extends RuntimeException {
  public AccountTransferException(String problem) {
		super("Error: account transfer is not possible: " + problem);
	}
}