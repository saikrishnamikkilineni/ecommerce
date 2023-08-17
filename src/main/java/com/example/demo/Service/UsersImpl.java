package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.MyRepo.UsersRepository;
import com.example.demo.status.UserStatus;

@Service
public class UsersImpl implements UsersInterface {

	@Autowired
	UsersRepository UsersRepo;
	
	
	@Override
	public Users addUsers(Users users) {
		
		return UsersRepo.save(users); 
	}


	@Override
	public Users blockUser(int User_id) { 
		Optional<Users> optionalUsers =UsersRepo.findById(User_id);
		if(optionalUsers.isPresent())
		{
			 Users users = optionalUsers.get();
			Users.setStatus(users, UserStatus.Blocked); 
			UsersRepo.save(users);
			return users;
		}
		else { 
			return null;
		}
	}


	@Override
	public Users unblock(int User_id) {
		Optional<Users> optionalUsers = UsersRepo.findById(User_id);
		if(optionalUsers.isPresent())
		{
			Users users=optionalUsers.get();
			Users.setStatus(users, UserStatus.UnBlocked);
			UsersRepo.save(users);
			return users;
		}
		else {
			return null;
		}
	}


	@Override
	public void deleteUsers(int User_id) {
		UsersRepo.deleteById(User_id);
		
		
	}


	@Override
	public List<Users> getUsersById() {
		List<Users> viewAll= UsersRepo.findAll();
		for(Users users: viewAll) {
			users.setPassword(null);//it will exclude from the user details
		}
		return viewAll;
	}
	

	
	
}
