package pe.com.stefanini.group.escuelajava.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.stefanini.group.escuelajava.model.response.OrderResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Order;
import pe.com.stefanini.group.escuelajava.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<Page<Order>> getAllOrdersToPage(
			@RequestParam(required = false, defaultValue = "0")Integer page,
			@RequestParam(required = false, defaultValue = "5") Integer size){
			Pageable pageable = PageRequest.of(page, size);
		Page<Order> order= orderService.getAllOrders(pageable);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping("/orders/procedure")
	public ResponseEntity<List<OrderResponse>> findAllProcedure(){
		List<OrderResponse> procedure = orderService.findByReporteOrdenesAtendidasStatus2();
		return new ResponseEntity<>(procedure, HttpStatus.OK);
		
	}
	
	@GetMapping("/orders/view")
	public ResponseEntity<List<OrderResponse>> findAllview(){
		List<OrderResponse> procedure = orderService.findByViewReportOrderPendientesUltimosTresMesSatado1();
		return new ResponseEntity<>(procedure, HttpStatus.OK);
		
	}

}
