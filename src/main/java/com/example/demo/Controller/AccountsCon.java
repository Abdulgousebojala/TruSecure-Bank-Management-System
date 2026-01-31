package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.Accounts;
import com.example.demo.Service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountsCon {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Accounts> createAccount(@RequestBody Accounts account){
        return ResponseEntity.ok(accountService.createAccounts(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountsEntityById(@PathVariable int id){
        Accounts account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/all/user/{userId}")
    public ResponseEntity<List<Accounts>> getAllAccountsByUserId(@PathVariable("user_id") int userId){
        return ResponseEntity.ok(accountService.getAccountsByUserId(userId));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Accounts>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    
    @PutMapping("/deposit/{accountId}/{amount}")
    public ResponseEntity<Accounts> deposit(@PathVariable int accountId, @PathVariable double amount){
        Accounts updated= accountService.deposit(accountId, amount);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/withdraw/{accountId}/{amount}")
    public ResponseEntity<Accounts> withdraw(@PathVariable int accountId, @PathVariable double amount){
        Accounts updated = accountService.withdraw(accountId, amount);
        return ResponseEntity.ok(updated);
    }
    @PutMapping("/transfer/{fromId}/{toId}/{amount}")
    public ResponseEntity<Accounts> transfer(@PathVariable int fromId, @PathVariable int toId, @PathVariable double amount){
        Accounts updated = accountService.transfer(fromId, toId, amount);
        return ResponseEntity.ok(updated);
    }

}