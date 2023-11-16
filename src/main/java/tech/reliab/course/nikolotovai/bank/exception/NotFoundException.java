package tech.reliab.course.nikolotovai.bank.exception;

public class NotFoundException extends Exception {
  public NotFoundException(String entity, int id) {
		super("Error: " + entity + " with id: " + id + " was not found.");
	}
}