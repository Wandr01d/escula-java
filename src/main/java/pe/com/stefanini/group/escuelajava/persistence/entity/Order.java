package pe.com.stefanini.group.escuelajava.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
	
	private static final long serialVersionUID = -3213522907446659815L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="order_id ")
	private Integer orderId;
	@Column
	private Integer totalOrderAmount;
	@Column
	private Double  totalOrderPrice; 
	@Column
	private String orderDate;
	@Column
	private String serviceOrderDate;
	@Column
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;


}
