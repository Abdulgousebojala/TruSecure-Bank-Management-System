package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Transactions;
import com.example.demo.Service.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionsCon {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<Transactions>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/account/{account_id}")
    public ResponseEntity<List<Transactions>> getTransactionsByAccountId(@PathVariable("account_id")int accountId){
        return ResponseEntity.ok(transactionService.getTransactionsByAccountId(accountId));
    }

    @PostMapping("/record")
    public ResponseEntity<Transactions> recordTransactions(@RequestBody Transactions transaction){
        return ResponseEntity.ok(transactionService.recordTransactions(transaction));
    }





    
}
