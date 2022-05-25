package com.learning.bankingapp.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingapp.Repo.CustomerRepo;
import com.learning.bankingapp.Repo.StaffRepo;
import com.learning.bankingapp.Repo.UserRepository;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.entity.User;
import com.learning.bankingapp.enums.UserType;
import com.learning.bankingapp.jwt.JwtUtils;
import com.learning.bankingapp.payload.request.LoginRequest;
import com.learning.bankingapp.payload.request.SignupRequest;
import com.learning.bankingapp.payload.response.JwtResponse;
import com.learning.bankingapp.payload.response.MessageResponse;
import com.learning.bankingapp.service.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
 CustomerRepo customerRepository;
  
  @Autowired
  StaffRepo staffRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/customer/authenticate")
  public ResponseEntity<?> authenticateCustomer(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getUsertype()));
  }
  
  @PostMapping("/staff/authenticate")
  public ResponseEntity<?> authenticateStaff(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getUsertype()));
  }
  
  @PostMapping("/Admin/authenticate")
  public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getUsertype()));
  }

  @PostMapping("/customer/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    // Create new user's account
    Customer customer = new Customer(signUpRequest.getUsername(), 
               signUpRequest.getFullname(),
               encoder.encode(signUpRequest.getPassword()),
               UserType.CUSTOMER);

    customerRepository.save(customer);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  @PostMapping("/admin/staff")
  public ResponseEntity<?> registerStaff(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    // Create new user's account
   Staff staff= new Staff(signUpRequest.getUsername(), 
               signUpRequest.getFullname(),
               encoder.encode(signUpRequest.getPassword()),
               UserType.STAFF);

    staffRepository.save(staff);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
  

