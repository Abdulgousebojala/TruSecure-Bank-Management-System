package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    
    @Override
    public Users createUsers(Users users) {
        return userRepository.save(users);
    }

    
    @Override
    public Users getUserById(int id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

   
    @Override
    public Users updateUser(int user_id, Users user) {
        Users existingUser = userRepository.findById(user_id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setMobile(user.getMobile());

        return userRepository.save(existingUser);
    }

    
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    
    @Override
    public Users login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
            .orElseThrow(() -> new RuntimeException("Invalid Username or Password"));
    }
}
