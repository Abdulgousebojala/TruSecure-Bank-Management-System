package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Users;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UsersCon {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/create")
    public ResponseEntity<Users> createUsers(@RequestBody Users user){
        return ResponseEntity.ok(userService.createUsers(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        Users user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable int userId, @RequestBody Users user){
        Users updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}
