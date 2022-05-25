package com.learning.bankingapp.payload.response;



import com.learning.bankingapp.enums.UserType;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private String id;
  private String username;
  private UserType usertype;

  public UserType getUsertype() {
	return usertype;
}

public void setUsertype(UserType usertype) {
	this.usertype = usertype;
}

public JwtResponse(String accessToken, String id, String username, UserType usertype) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.usertype = usertype;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  
}
