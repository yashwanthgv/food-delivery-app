package com.bigapps.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigapps.foodcatalogue.dto.FoodCataloguePage;
import com.bigapps.foodcatalogue.dto.FoodItemDTO;
import com.bigapps.foodcatalogue.service.FoodcatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodcatalogueController {

	@Autowired
	FoodcatalogueService foodcatalogueService;

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		FoodItemDTO foodItemSaved = foodcatalogueService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		FoodCataloguePage foodCataloguePage = foodcatalogueService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

	}

}
