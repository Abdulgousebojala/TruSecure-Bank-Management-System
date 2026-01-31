package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Accounts;

public interface AccountService {

    Accounts createAccounts(Accounts account);

    Accounts getAccountById(int id);

    List<Accounts> getAccountsByUserId(int userId);  

    List<Accounts> getAllAccounts();

    Accounts deposit(int accountid, double amount);

    Accounts withdraw(int accountid, double amount);

    Accounts transfer(int fromAccountId, int toAccountId, double amount);
}
