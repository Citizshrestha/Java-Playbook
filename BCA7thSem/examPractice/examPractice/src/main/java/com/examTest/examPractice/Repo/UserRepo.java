package com.examTest.examPractice.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examTest.examPractice.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User>  findByEmail(String email);

    boolean existsByEmail(String email);

}