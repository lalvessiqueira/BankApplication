package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.bankingapp.entity.User;
import com.learning.bankingapp.enums.UserType;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private String id;

  private String username;

  @JsonIgnore
  private String password;
  
  private UserType usertype;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(String id, String username, String password,
		   UserType usertype
		 // Collection<? extends GrantedAuthority> authorities
		  ) {
    this.id = id;
    this.username = username;
    this.password = password;
    //this.authorities = authorities;
    this.usertype = usertype;
  }

  public static UserDetailsImpl build(User user) {
	  
	 /*
	  Set<UserType> po = new HashSet<>();
	  po.add(user.getUsertype());
	  
	  List<GrantedAuthority> authorities = po.stream()
		        .map(role -> new SimpleGrantedAuthority(user.getUsertype().name()))
		        .collect(Collectors.toList());
*/
    return new UserDetailsImpl(
        user.getUid(), 
        user.getUsername(), 
        user.getPassword(), 
        user.getUsertype()
        //authorities
        );
  }
  
  

  public UserType getUsertype() {
	return usertype;
}


@Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }
  
  public String getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
