package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	  public ResponseEntity<Users> addUsers(@RequestBody Users users) {
		  Users addUsers=userInterface.createUsers(users);
		  return ResponseEntity.ok(addUsers);
	  }
	  
	  
	    
	  
	  @PostMapping("/addToCart/{user_name}")
	    public ResponseEntity<String> addToCart(@PathVariable("user_name") String user_name, @RequestBody List<Integer> cart) {
	        userInterface.addToCart(user_name, cart);
	        return ResponseEntity.ok("Added to cart successfully");
	    }
	  
	  
	  @PostMapping("/submitCart/{user_name}")
	    public ResponseEntity<Orders> submitCart(@PathVariable String user_name) {
	        Orders order = ordersInterface.submitCart(user_name);
	        return ResponseEntity.ok(order);
	    }
	  
	
	  
	  @PutMapping("/editprofile/{user_id}")
	    public ResponseEntity<Users> updateUser(@PathVariable int user_id, @RequestBody Users updatedUser) {
	        Users updated = userInterface.updateUser(user_id, updatedUser);
	        return ResponseEntity.ok(updated);
	    }
	  
}
