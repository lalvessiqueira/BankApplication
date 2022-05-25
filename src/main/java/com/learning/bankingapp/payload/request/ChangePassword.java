package com.learning.bankingapp.payload.request;


import javax.validation.constraints.*;


public class ChangePassword {

	@NotBlank (message = "password must not be blank")
	 @Size(min = 6, max = 40,message = "Password must be between 6-40 characters")
  private String password;

public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
