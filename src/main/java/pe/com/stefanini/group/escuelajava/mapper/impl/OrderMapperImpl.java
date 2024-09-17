package pe.com.stefanini.group.escuelajava.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.stefanini.group.escuelajava.mapper.OrderMapper;
import pe.com.stefanini.group.escuelajava.model.response.OrderResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Order;

@Component
public class OrderMapperImpl implements OrderMapper{

	@Override
	public Order toOrder(OrderResponse orderResponse) {
		if(orderResponse == null) {
			return null;
		}
		Order order = new Order();
		order.setOrderId(orderResponse.getOrderId());
		order.setTotalOrderAmount(orderResponse.getTotalOrderAmount());
		order.setTotalOrderPrice(orderResponse.getTotalOrderPrice());
		order.setOrderDate(orderResponse.getOrderDate());
		order.setServiceOrderDate(orderResponse.getServiceOrderDate());
		order.setStatus(orderResponse.getStatus());
		order.setCustomer(orderResponse.getCustomer());
		
		return order;
	}

	@Override
	public OrderResponse toOrderResponse(Order order) {
		if(order == null) {
			return null;
		}
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(order.getOrderId());
		orderResponse.setTotalOrderAmount(order.getTotalOrderAmount());
		orderResponse.setTotalOrderPrice(order.getTotalOrderPrice());
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setServiceOrderDate(order.getServiceOrderDate());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setCustomer(order.getCustomer());
		
		return orderResponse;
	}

	@Override
	public List<OrderResponse> toOrdersResponses(List<Order> orders) {
		if(orders == null) {
			return null;
		}
		List<OrderResponse> list = new ArrayList<OrderResponse>(orders.size());
		for(Order order: orders) {
			list.add(toOrderResponse(order));
		}
		return list;
	}

}
