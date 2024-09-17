package pe.com.stefanini.group.escuelajava.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductResponse {
	
	
	private Integer productId;	
	private String productName;	
	private Double productPrice;
	private Integer status;

}
