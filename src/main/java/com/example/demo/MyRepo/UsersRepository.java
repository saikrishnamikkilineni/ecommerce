package com.example.demo.MyRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

	@Query(value="select * from users where user_name =?1",nativeQuery = true)
	Users findByUser_name(String user_name);
	
	@Query(value="select * from users where user_name =?1 and password=?2", nativeQuery = true)
	Users getUserPwd(String user_name,String password);

	
	
}
