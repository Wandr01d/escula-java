package pe.com.stefanini.group.escuelajava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.stefanini.group.escuelajava.mapper.OrderMapper;
import pe.com.stefanini.group.escuelajava.model.response.OrderResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Order;
import pe.com.stefanini.group.escuelajava.persistence.repository.OrderRepository;
import pe.com.stefanini.group.escuelajava.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Page<Order> getAllOrders(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<OrderResponse> findByReporteOrdenesAtendidasStatus2() {
		return orderMapper.toOrdersResponses(orderRepository.findByReporteOrdenesAtendidasStatus2());
	}

	@Override
	public List<OrderResponse> findByViewReportOrderPendientesUltimosTresMesSatado1() {
		return orderMapper.toOrdersResponses(orderRepository.findByViewReportOrderPendientesUltimosTresMesSatado1());
	}

}
