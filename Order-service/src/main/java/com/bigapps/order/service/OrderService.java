package com.bigapps.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bigapps.order.entity.Order;
import com.bigapps.order.entity.dto.OrderDTO;
import com.bigapps.order.entity.dto.OrderDTOFromFE;
import com.bigapps.order.entity.dto.UserDTO;
import com.bigapps.order.mapper.OrderMapper;
import com.bigapps.order.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;
	
	public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = null; //fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
       return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }

}
