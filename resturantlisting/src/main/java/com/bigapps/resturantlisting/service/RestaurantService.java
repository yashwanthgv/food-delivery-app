package com.bigapps.resturantlisting.service;

import com.bigapps.resturantlisting.RestaurantMapper;
import com.bigapps.resturantlisting.dto.RestaurantDto;
import com.bigapps.resturantlisting.entity.Restaurant;
import com.bigapps.resturantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDto> findAll() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDto> restaurantDtoList = restaurants.stream().map(restaurant -> RestaurantMapper.RESTAURANT_MAPPER.mapRestaurantToRestaurantDTO(restaurant))
                .collect(Collectors.toList());
        return restaurantDtoList;
    }

    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepo.save(RestaurantMapper.RESTAURANT_MAPPER.mapRestaurantDTOToRestaurant(restaurantDto));
        return RestaurantMapper.RESTAURANT_MAPPER.mapRestaurantToRestaurantDTO(restaurant);
    }

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(id);
        if(optionalRestaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.RESTAURANT_MAPPER.mapRestaurantToRestaurantDTO(optionalRestaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
