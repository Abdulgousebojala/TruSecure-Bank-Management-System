package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Accounts;
import com.example.demo.Repository.AccountRepository;



@Service
public class AccountServiceImpl implements AccountService {
    

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Accounts createAccounts(Accounts account){
        return accountRepository.save(account);
    }
    @Override
    public List<Accounts> getAllAccounts() {
        return accountRepository.findAll();   
    }
    @Override
    public Accounts getAccountById(int id){
        return accountRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Account not found"));
    }
    @Override
    public List<Accounts> getAccountsByUserId(int userId){
        return accountRepository.findByUser_UserId(userId);
    }
    @Override
    public Accounts deposit(int accountid, double amount){

        Accounts account = getAccountById(accountid);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
    @Override
    public Accounts withdraw(int accountid, double amount){
        
        Accounts account = getAccountById(accountid);
        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        } 
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
 
    }
    @Override
    public Accounts transfer(int fromId, int toId, double amount){
        withdraw(fromId, amount);
        deposit(toId, amount);
        return getAccountById(fromId);
    }

}
