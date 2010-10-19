package org.xin.lab;

public class PersonImpl implements MyResource {

  private String name;
  private String email;

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getEmail() {
    return email;
  }
}
