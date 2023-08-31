package com.example.demo.Service;



import java.util.List;


import com.example.demo.Model.Users;

public interface UserInterface {

	
	Users createUsers(Users user);
	Users login(String user_name, String password);
	Users getUserByUser_name(String user_name);
	List<Users> getAllUsers();
	void addToCart(String username,List<Integer> product);
	Users updateUser(int user_id, Users updatedUser);
	
	
	
}
