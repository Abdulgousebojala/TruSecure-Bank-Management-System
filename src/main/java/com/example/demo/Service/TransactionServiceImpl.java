package com.example.demo.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Transactions;
import com.example.demo.Repository.TransactionsRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionsRepository transactionRepository;

    @Override
    public Transactions recordTransactions(Transactions transaction) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = LocalDateTime.now().format(formatter);

        transaction.setTransactionDate(now);

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transactions> getTransactionsByAccountId(int accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
