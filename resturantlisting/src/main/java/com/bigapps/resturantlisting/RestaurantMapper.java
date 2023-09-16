package com.bigapps.resturantlisting;

import com.bigapps.resturantlisting.dto.RestaurantDto;
import com.bigapps.resturantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RestaurantMapper {

    RestaurantMapper RESTAURANT_MAPPER= Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant);

}
