package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Product addProduct(@RequestBody Product product) {
		ServiceInterface.addProduct(product);
		return  product;
	}
	
	@DeleteMapping("/deleteBystock")
	public void deleteBystock(@RequestBody Product product) {
		ServiceInterface.deleteBystock(product.getStock());
	
	}
	
	@GetMapping("/getProductByname") 
	public Product getProductByname(@RequestBody Product product) {
		 return ServiceInterface.getProductByname(product.getProduct_name());
	}
	
	@Autowired
	UsersImpl UsersInterface;
	
	@PostMapping("/addUsers")
	public Users addUsers(@RequestBody Users users) {
		return UsersInterface.addUsers(users);
	}
	
	@PutMapping("/{user_Id}/blockUser")
	public Users blockUser(@PathVariable int user_Id) {
		return UsersInterface.blockUser(user_Id);
	}
	
	@PutMapping("/{user_Id}/unblock")
	public Users unblock(@PathVariable int user_Id) {
		return UsersInterface.unblock(user_Id);
	}
	
	@DeleteMapping("/deleteUsers")
	public void deleteUsers(@RequestBody Users users) {
		UsersInterface.deleteUsers(users.getUser_id());
	}
	
	@GetMapping("/getUsersById") 
	public  List<Users> getUsersById() {
		return UsersInterface.getUsersById();
		
	}
	
	
	@Autowired
	OrdersImpl OrdersInterface;
	
	@PostMapping("/addOrders")
	public Orders addOrders(@RequestBody OrderDto orders) {
		return OrdersInterface.addOrders(orders);
	}
	
	@GetMapping("/getAllOrder")
	public List<Orders> getAllorder(@RequestBody Orders orders) {
		return OrdersInterface.getAllOrder();
	}
	
	@DeleteMapping("/deleteOrderById")
	public void deleteOrderById(@RequestBody Orders orders) {
		OrdersInterface.deleteOrderById(orders.getOrder_id());
	}
	
}
