package com.kodnest.music.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.music.entity.User;

@Service
public interface UserService {

public void postUser(User user);
public User emailExist(User user);
public boolean validUser(String email, String password);
public String getRole(String email);
  void updatePassword(String email,String password);
  User getUSer(String email);
public void updateUser(User user);
public void saveUser(User user);
public User isPremium(String email);

}
