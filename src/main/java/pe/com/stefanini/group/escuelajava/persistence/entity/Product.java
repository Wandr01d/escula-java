package pe.com.stefanini.group.escuelajava.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product implements Serializable{
	
	private static final long serialVersionUID = 4201291992896678630L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;	
	@Column
	private String productName;	
	@Column
	private Double productPrice;
	@Column
	private Integer status;
	
	
	


}
