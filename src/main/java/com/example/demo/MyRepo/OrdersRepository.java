package com.example.demo.MyRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
