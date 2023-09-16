package com.bigapps.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bigapps.order.entity.dto.FoodItemsDTO;
import com.bigapps.order.entity.dto.Restaurant;
import com.bigapps.order.entity.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order {
	private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}
