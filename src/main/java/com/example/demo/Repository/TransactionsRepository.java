package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Transactions;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    
    List<Transactions> findByAccountId(int accountId);
    
}
