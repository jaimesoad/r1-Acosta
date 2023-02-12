package com.example.r1acosta.api.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int accountNumber;
    public String clientName;
    public float balance;
    public boolean accountState = true;

    @Modifying
    @Query()
    public static void DeleteAccount(){}
}
