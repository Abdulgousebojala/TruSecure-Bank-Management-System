package com.example.demo.Service;

import java.util.*;
import com.example.demo.Model.Transactions;

public interface TransactionService {

    Transactions recordTransactions(Transactions transaction);

    List<Transactions> getTransactionsByAccountId(int account_id);

    List<Transactions> getAllTransactions();


}