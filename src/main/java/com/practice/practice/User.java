package com.practice.practice;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @Column(name="username")
    private String username;
   @Column(name = "password")
    private String password;
   @Column(name="first_name")
    private String firstName;
   @Column(name="last_name")
    private String lastName;
   @Column(name="dob")
    private String dob;
   @OneToMany(mappedBy = "user")
   @Setter(AccessLevel.NONE)
   private List<BankAccount> accounts = new ArrayList<BankAccount>();


   public void setAccounts(BankAccount account){
       this.accounts.add(account);
   }

}
