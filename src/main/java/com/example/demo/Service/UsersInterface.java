package com.example.demo.Service;



import java.util.List;

import com.example.demo.Model.Users;

public interface UsersInterface {

	public Users addUsers(Users users);
	public Users blockUser(int User_id);
	public Users unblock(int User_id);
	void deleteUsers(int User_id);
	public List<Users> getUsersById();  
	
}
