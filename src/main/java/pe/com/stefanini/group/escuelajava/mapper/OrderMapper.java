package pe.com.stefanini.group.escuelajava.mapper;

import java.util.List;

import pe.com.stefanini.group.escuelajava.model.response.OrderResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Order;




public interface OrderMapper {

	Order toOrder(OrderResponse orderResponse);
	
	OrderResponse toOrderResponse(Order order);
	
	List<OrderResponse> toOrdersResponses(List<Order> order);
	
}
