package com.bigapps.resturantlisting.controller;

import com.bigapps.resturantlisting.dto.RestaurantDto;
import com.bigapps.resturantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        List<RestaurantDto> restaurantDtoList = restaurantService.findAll();
        return new ResponseEntity<>(restaurantDtoList, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto){
       return new ResponseEntity<>(restaurantService.addRestaurantInDB(restaurantDto),HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDto> findRestaurantById(@PathVariable Integer id) {
        return restaurantService.fetchRestaurantById(id);
    }
}
