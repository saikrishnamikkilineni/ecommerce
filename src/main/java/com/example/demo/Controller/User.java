package com.example.demo.Controller;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.*;

import com.example.demo.Service.OrdersInterface;
import com.example.demo.Service.ServiceInterface;
import com.example.demo.Service.UserInterface;
import com.example.demo.Service.UsersInterface;

@RestController
public class User {
	
	@Autowired
	ServiceInterface serviceInterface;
	
	@Autowired
	UserInterface userInterface;
	
	@Autowired
	UsersInterface usersInterface;
	
	@Autowired
	OrdersInterface ordersInterface;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody login login) {
        Users success = userInterface.login(login.getUsername(), login.getPassword());
        if (success != null) {
            return new ResponseEntity<>("Login successful",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed",HttpStatus.OK);
        }
    }
	
	  @PostMapping("/createuser")
	  public Users addUsers(@RequestBody Users users) {
		  return userInterface.createUsers(users);
	  }
	
	
	  
}
