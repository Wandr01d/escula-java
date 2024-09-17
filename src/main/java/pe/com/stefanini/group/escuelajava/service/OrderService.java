package pe.com.stefanini.group.escuelajava.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.com.stefanini.group.escuelajava.model.response.OrderResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Order;

public interface OrderService {

	Page<Order> getAllOrders(Pageable pageable);
	List<OrderResponse>  findByReporteOrdenesAtendidasStatus2();
	List<OrderResponse> findByViewReportOrderPendientesUltimosTresMesSatado1();
	

}
