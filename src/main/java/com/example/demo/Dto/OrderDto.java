package com.example.demo.Dto;

public class OrderDto {
private int user_id,product_id;
String status;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
