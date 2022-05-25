package com.learning.bankingapp.payload.request;


import javax.validation.constraints.*;


public class ChangePassword {

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
