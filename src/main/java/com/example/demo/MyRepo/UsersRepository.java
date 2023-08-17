package com.example.demo.MyRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

	
	Users findByUser_name(String user_name);
	@Modifying
	@Query(value="select * from users where user_name =?1 and password=?2", nativeQuery = true)
	Users getUserPwd(String user_name,String password);
}
