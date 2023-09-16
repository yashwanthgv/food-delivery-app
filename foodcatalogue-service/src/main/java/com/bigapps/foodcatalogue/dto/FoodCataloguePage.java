package com.bigapps.foodcatalogue.dto;

import java.util.List;

import com.bigapps.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
	private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
