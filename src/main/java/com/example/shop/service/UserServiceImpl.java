package com.example.shop.service;

import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User saveUser(User newUser) {

        newUser.setAvatar("https://t3.ftcdn.net/jpg/02/09/37/00/360_F_209370065_JLXhrc5inEmGl52SyvSPeVB23hB6IjrR.jpg");
        return repository.save(newUser);
    }

    @Override
    public User updateUser(Integer id, String address, String numberPhone) {
        User user = repository.findById(id).orElse(null);
        if (user == null) {
            return null;
        } else  {
            user.setAddress(address);
            user.setNumberPhone(numberPhone);
            repository.save(user);
            return user;
        }
    }
}