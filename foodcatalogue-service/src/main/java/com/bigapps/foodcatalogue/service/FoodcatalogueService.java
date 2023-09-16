package com.bigapps.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bigapps.foodcatalogue.dto.FoodCataloguePage;
import com.bigapps.foodcatalogue.dto.FoodItemDTO;
import com.bigapps.foodcatalogue.dto.Restaurant;
import com.bigapps.foodcatalogue.entity.FoodItem;
import com.bigapps.foodcatalogue.mapper.FoodItemMapper;
import com.bigapps.foodcatalogue.repository.FoodcatalogueRepo;

@Service
public class FoodcatalogueService {
	
	@Autowired
	FoodcatalogueRepo foodcatalogueRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodcatalogueRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSavedInDB);
    }
	
	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }
	
	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodcatalogueRepo.findByRestaurantId(restaurantId);
    }

}
