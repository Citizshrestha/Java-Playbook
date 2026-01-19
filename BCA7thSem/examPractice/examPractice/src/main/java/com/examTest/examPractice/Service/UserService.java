package com.examTest.examPractice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examTest.examPractice.Repo.UserRepo;
import com.examTest.examPractice.model.User;

@Service
public class UserService {
    @Autowired 
    private UserRepo userRepo;

    public User createUser(User user) {
    if (userRepo.existsByEmail(user.getEmail())) {
        throw new IllegalArgumentException("Email " + user.getEmail() + " already exists");
    }
    return userRepo.save(user);
}

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with that id"));
    }

    public User updateUser(Long userId, User updatedUser){
        User existingUser = getUserById(userId);

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAddress(updatedUser.getAddress());

        return userRepo.save(existingUser);

    }

    public void deleteUser(Long userId){
        if (!userRepo.existsById(userId)){
            throw new RuntimeException("User doesnot exists with that id");
        }
       userRepo.deleteById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

}
