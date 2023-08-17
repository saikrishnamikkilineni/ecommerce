package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Users;
import com.example.demo.MyRepo.UsersRepository;

@Service
public class UserImpl  implements UserInterface{

	@Autowired
	UsersRepository UsersRepo;
	
	
	@Override
	public Users createUsers(Users user) {
		
		return UsersRepo.save(user);
	}


	@Override
	public Users login(String user_name, String password) {
		return UsersRepo.getUserPwd(user_name, password);
	}


	@SuppressWarnings("unused")
	@Override
	public void addToCart(String username, List<Product> product) {
		Users users=UsersRepo.findByUser_name(username);
		
	}


	@Override
	public Users editUserProfile(String user_name, Users user) {
		Users users1 = getUserByUser_name(user_name);
        users1.setEmail(user_name);
        users1.setUser_name(user_name);
        users1.setPassword(user_name);
return UsersRepo.save(users1);
	}


	@Override
	public Users getUserByUser_name(String user_name) {
		return UsersRepo.findByUser_name(user_name);
	}
	
	
	
	

}
