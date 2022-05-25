package com.learning.bankingapp.payload.request;


import javax.validation.constraints.*;

import com.learning.bankingapp.enums.UserType;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  private String fullname;

  private UserType usertype;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
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