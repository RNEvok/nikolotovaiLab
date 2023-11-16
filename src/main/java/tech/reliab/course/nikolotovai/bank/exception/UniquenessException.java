package tech.reliab.course.nikolotovai.bank.exception;

public class UniquenessException extends Exception {
  public UniquenessException(String entity, int id) {
		super("Error: " + entity + " with id: " + id + " already exists.");
	}
}