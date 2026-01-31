package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    
   List<Accounts> findByUser_UserId(int userId);


}
