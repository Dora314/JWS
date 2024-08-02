package com.vn.jewelry_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vn.jewelry_management_system.domain.User;
import com.vn.jewelry_management_system.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleSaveUser(User user) {
        User anh = this.userRepository.save(user);
        System.out.println(anh);
        return anh;
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

}
