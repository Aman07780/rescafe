package com.springboot.web.service;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.springboot.web.modal.User;
import com.springboot.web.repository.UserRepo;
 
import exception.UserNotFoundException;
 
@Service
public class UserService {
 
    @Autowired
    private UserRepo userRepo;
 
    public User newUser(User user) {
        return userRepo.save(user);
    }
 
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
 
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User", "id", id);
        }
        return userOptional.get();
    }
 
    public User updateUser(Long id, User newUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(newUser.getUsername());
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        return userRepo.save(existingUser);
    }
 
    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new UserNotFoundException("User", "id", id);
        }
        userRepo.deleteById(id);
    }
}