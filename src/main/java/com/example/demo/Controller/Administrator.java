package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Product;
import com.example.demo.Model.Users;
import com.example.demo.Service.OrdersImpl;
import com.example.demo.Service.ServiceImpl;
import com.example.demo.Service.UsersImpl;

@RestController 
public class Administrator {

	@Autowired
	ServiceImpl ServiceInterface;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		ServiceInterface.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@DeleteMapping("/deleteBystock")
	public ResponseEntity<Void> deleteBystock(@RequestBody Product product) {
		ServiceInterface.deleteBystock(product.getStock());
		return ResponseEntity.noContent().build();	
	}
	
	@GetMapping("/getProductByname") 
	public ResponseEntity<Product> getProductByname(@RequestBody Product product) {
		Product foundProduct=ServiceInterface.getProductByname(product.getProduct_name());
		 return ResponseEntity.ok(foundProduct);
	}
	
	@GetMapping("/viewproduct")
    public List<Product> getAllProducts(){
		return ServiceInterface.getAllProduct();	
    }
    
	
	
	@Autowired
	UsersImpl UsersInterface;
	
	@PostMapping("/addUsers")
	public ResponseEntity<Users> addUsers(@RequestBody Users users) {
		Users addedUser= UsersInterface.addUsers(users);
		return ResponseEntity.ok(addedUser);
	}
	
	@PutMapping("/{user_Id}/blockUser")
	public ResponseEntity<Users> blockUser(@PathVariable int user_Id) {
		Users blockUser =UsersInterface.blockUser(user_Id);
		if(blockUser!=null) {
			return ResponseEntity.ok(blockUser);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{user_Id}/unblock")
	public ResponseEntity<Users> unblock(@PathVariable int user_Id) {
		Users unBlock =UsersInterface.unblock(user_Id);
		if(unBlock != null) {
			return ResponseEntity.ok(unBlock);
			
		}
		else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<Void> deleteUsers(@RequestBody Users users) {
		UsersInterface.deleteUsers(users.getUser_id());
		return ResponseEntity.notFound().build();	
		}
	
	
	@GetMapping("/getUsersById") 
	public  ResponseEntity<List<Users>> getUsersById() {
		List<Users> users=  UsersInterface.getUsersById();
		if(!users.isEmpty()) {
			return ResponseEntity.ok(users);
		}
		else {
			return ResponseEntity.noContent().build();		
					}
	}
	
	
	
	@Autowired
	OrdersImpl OrdersInterface;
	
	@PostMapping("/addOrders")
	public ResponseEntity<Orders> addOrders(@RequestBody OrderDto orders) {
		Orders orderAdded= OrdersInterface.addOrders(orders);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderAdded);
				
	}
	
	@GetMapping("/getAllOrder")
	public ResponseEntity<List<Orders>> getAllorder(@RequestBody Orders orders) {
		List<Orders> allOrders= OrdersInterface.getAllOrder();
		if(!allOrders.isEmpty()) {
			return ResponseEntity.ok(allOrders);
		}
		else {
			return ResponseEntity.noContent().build();
			
		}
	}
	
	
	@DeleteMapping("/deleteOrderById")
	public ResponseEntity<Void> deleteOrderById(@RequestBody Orders orders) {
		OrdersInterface.deleteOrderById(orders.getOrder_id());
		return ResponseEntity.noContent().build();
	}
	
}
