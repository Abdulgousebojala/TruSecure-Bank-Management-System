package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Users;

public interface UserService {
    Users createUsers(Users users);
    Users getUserById(int id);
    List<Users> getAllUsers();
    Users updateUser(int user_id, Users user);
    void deleteUser(int id);
    Users login(String username, String password); 

}
