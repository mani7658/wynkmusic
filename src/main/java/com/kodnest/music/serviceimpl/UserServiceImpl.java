package com.kodnest.music.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.music.entity.User;
import com.kodnest.music.repository.UserRepository;
import com.kodnest.music.service.UserService;

@Service
public class UserServiceImpl implements UserService{
@Autowired	
UserRepository ur;

@Override
public void postUser(User user) {
	ur.save(user);
	
}
public User emailExist(User user) {
	User details=ur.findByEmail(user.getEmail());
	if(details==null) {
		return null;
	}
	else return user;
}
@Override
public boolean validUser(String email, String password) {
	User user=ur.findByEmail(email);
	
	
	if(user==null) {
		return false;
	}
	String dbpwd=user.getPassword();
	 if(password.equals(dbpwd)&&email.equals(user.getEmail())) {
			return true;
		}
		return false;
}
@Override
public String getRole(String email) {
     User user=ur.findByEmail(email);
     return user.getRole();
}
@Override
public void updatePassword(String email,String password) {
	
	User user=ur.findByEmail(email);
	String pwd=user.getPassword();
	pwd=password;
	user.setPassword(pwd);
	ur.save(user);
	
}
@Override
public User getUSer(String email) {
	
	return ur.findByEmail(email);
}
@Override
public void updateUser(User user) {
	ur.save(user);
	
}
@Override
public void saveUser(User user) {
	// TODO Auto-generated method stub
	
}
@Override
public User isPremium(String email) {
	User user=ur.findByEmail(email);
	
		return user;
	
	
}


}
