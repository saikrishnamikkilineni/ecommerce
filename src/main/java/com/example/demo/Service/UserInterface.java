package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;
import com.example.demo.Model.Users;

public interface UserInterface {

	
	Users createUsers(Users user);
	Users login(String user_name, String password);
	void addToCart(String username,List<Product> product);
	Users editUserProfile(String user_name, Users user);
	Users getUserByUser_name(String user_name);
}
