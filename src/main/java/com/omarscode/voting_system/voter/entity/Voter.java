package com.omarscode.voting_system.voter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Voter {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    private String password;

    private String verificationCode;

    private LocalDateTime codeGeneratedAt;

    private boolean active;

    private boolean staff;

}
