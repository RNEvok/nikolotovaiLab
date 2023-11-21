package tech.reliab.course.nikolotovai.bank.exception;

public class UniquenessException extends RuntimeException {
  public UniquenessException(String entity, int id) {
		super("Error: " + entity + " with id: " + id + " already exists.");
	}
}