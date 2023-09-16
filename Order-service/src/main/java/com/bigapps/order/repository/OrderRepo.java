package com.bigapps.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bigapps.order.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {

}
