package com.cathay.homework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cathay.homework.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
