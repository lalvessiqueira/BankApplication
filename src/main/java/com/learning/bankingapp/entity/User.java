package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {

    @Id
    private String uid;
    @Column(name = "username")
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "usertype")
    private Usertype usertype;

    // security?
//    private String secretQuestion;
//    private String secretAnswer;

}