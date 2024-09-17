package pe.com.stefanini.group.escuelajava.model.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderResponse {
	
	private Integer orderId;
	private Integer totalOrderAmount;
	private Double  totalOrderPrice; 
	private String orderDate;
	private String serviceOrderDate;
	private Integer status;
	private Customer customer;



}
