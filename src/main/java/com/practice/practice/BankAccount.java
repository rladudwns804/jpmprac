package com.practice.practice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankAccount implements BankAccountInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountID;
    @JsonFormat(pattern= "yyyy-mm-dd")
    @Column(name = "Date_Opened")
    private Instant dateOpened;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;
    @Column
    private double accountBal;

    public double doTransaction(double balance, String type){
            return this.accountBal;
    }

}
