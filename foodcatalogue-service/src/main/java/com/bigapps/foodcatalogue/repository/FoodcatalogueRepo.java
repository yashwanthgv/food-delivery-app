package com.bigapps.foodcatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigapps.foodcatalogue.entity.FoodItem;

@Repository
public interface FoodcatalogueRepo extends JpaRepository<FoodItem, Integer>{
	
	 List<FoodItem> findByRestaurantId(Integer restaurantId);

}
