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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = -6391911506807073888L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column
	private Integer amount;
	@Column
	private Double  totalPrice;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private Order   order;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	

}
