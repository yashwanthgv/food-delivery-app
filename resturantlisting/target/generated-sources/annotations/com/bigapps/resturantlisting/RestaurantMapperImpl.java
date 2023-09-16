package com.bigapps.resturantlisting;

import com.bigapps.resturantlisting.dto.RestaurantDto;
import com.bigapps.resturantlisting.entity.Restaurant;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-15T09:23:34+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant mapRestaurantDTOToRestaurant(RestaurantDto restaurantDto) {
        if ( restaurantDto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( restaurantDto.getId() );
        restaurant.setName( restaurantDto.getName() );
        restaurant.setAddress( restaurantDto.getAddress() );
        restaurant.setCity( restaurantDto.getCity() );
        restaurant.setRestaurantDescription( restaurantDto.getRestaurantDescription() );

        return restaurant;
    }

    @Override
    public RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setId( restaurant.getId() );
        restaurantDto.setName( restaurant.getName() );
        restaurantDto.setAddress( restaurant.getAddress() );
        restaurantDto.setCity( restaurant.getCity() );
        restaurantDto.setRestaurantDescription( restaurant.getRestaurantDescription() );

        return restaurantDto;
    }
}
