package pe.com.stefanini.group.escuelajava.service;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.com.stefanini.group.escuelajava.model.response.ProductResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Product;
public interface ProductService {

	Page<Product> findByProductNameAndStatusPage(String productName, Integer status, Pageable pageable);
	List<ProductResponse> findAllProductToPage();
	ProductResponse findByProductId(Integer productId);
	ProductResponse saveProduct(ProductResponse productResponse);
	ProductResponse updateProduct(Integer productId, ProductResponse productResponse);
	
	
	
	
}
