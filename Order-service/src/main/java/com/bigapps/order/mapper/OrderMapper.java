package com.bigapps.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bigapps.order.entity.Order;
import com.bigapps.order.entity.dto.OrderDTO;

@Mapper
public interface OrderMapper  {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);
}
