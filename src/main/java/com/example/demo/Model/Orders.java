package com.example.demo.Model;


import java.util.Date;
import java.util.List;

import com.example.demo.status.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int order_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Users users;
	
	@ManyToMany
	private List<Product> products;
	@JoinColumn(name="product_id")
	
	
	@Column(name="order_date")
	Date order_date;
	
	
	 @Enumerated(EnumType.STRING)
	 @Column(name = "status")
	    OrderStatus status = OrderStatus.Pending;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date date) {
		this.order_date = date;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	
	
	
}
