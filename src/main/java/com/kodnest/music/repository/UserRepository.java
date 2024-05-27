package com.kodnest.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.music.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
public User findByEmail(String email);


}
