package pe.com.stefanini.group.escuelajava.mapper;

import java.util.List;



import pe.com.stefanini.group.escuelajava.model.response.ProductResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Product;

public interface ProductMapper {

	Product toProduct(ProductResponse productResponse);
	
	ProductResponse toProductResponse(Product product);
	
	List<ProductResponse> toProductsResponses(List<Product> products);
	
	void updateProduct(Product product, ProductResponse productResponse);
	
}
