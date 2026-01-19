package com.examTest.examPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examTest.examPractice.Service.UserService;
import com.examTest.examPractice.dto.ApiResponse;
import com.examTest.examPractice.model.User;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
  @Autowired UserService userService;


  @PostMapping
  public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody User user) {
      User createdUser = userService.createUser(user);

      ApiResponse<User> response = new ApiResponse<>("User created successfully", createdUser);
      return new ResponseEntity<>(response, HttpStatus.CREATED);
      
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
    List<User> fetchedUser = userService.getAllUsers();

    ApiResponse<List<User>> response = new ApiResponse<>("All Users fetched successfully", fetchedUser);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

    // GET USER BY ID - Fixed: Now works correctly
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ApiResponse<User> response = new ApiResponse<>("User fetched successfully", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // GET USER BY EMAIL - Fixed: Using /search with @RequestParam
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<User>> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);  // ← Fixed method name
        ApiResponse<User> response = new ApiResponse<>("User Found with email: " + user.getEmail(), user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @Valid @RequestBody User user){
      User updatedUser = userService.updateUser(id, user);

      ApiResponse<User> response = new ApiResponse<>("User updated successfully",updatedUser);

      return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);

    ApiResponse<Void> response = new ApiResponse<Void>("User deleted", null);
    
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
  
  
}
