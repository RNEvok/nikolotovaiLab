package reliab.course.nikolotovai.bank.entity;

import java.time.LocalDate;

public class Human {
  protected int id;
  protected String name;
  protected LocalDate birthDate;

  private void initializeWithDefaults() {
    id = -1;
    name = "No name";
    birthDate = null;
  }

  public Human() {
    initializeWithDefaults();
  }

  public Human(int id, String name, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }
}