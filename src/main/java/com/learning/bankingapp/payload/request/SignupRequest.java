package com.learning.bankingapp.payload.request;


import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import com.learning.bankingapp.enums.UserType;

public class SignupRequest {
	
	@NotBlank (message = "username must not be blank")
	@Size(max = 20,message = "username must be between 2-30 characters.")
	private String username;

  @NotBlank (message = "fullName must not be blank")
  @Length(min = 2, max = 30, message = "fullName must be between 2-30 characters. ")
  @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "fullName is invalid.")
 // @Size(max = 50)
  private String fullName;

  private UserType usertype;

  @NotBlank (message = "password must not be blank")
  @Size(min = 6, max = 40,message = "Password must be between 6-40 characters")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public UserType getUsertype() {
	return usertype;
}

public void setUsertype(UserType usertype) {
	this.usertype = usertype;
}

public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
