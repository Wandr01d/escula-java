package pe.com.stefanini.group.escuelajava.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import pe.com.stefanini.group.escuelajava.mapper.ProductMapper;
import pe.com.stefanini.group.escuelajava.model.response.ProductResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Product;

@Component
public class ProductMapperImpl implements ProductMapper{

	@Override
	public Product toProduct(ProductResponse productResponse) {
		if(productResponse == null) {
			return null;
		}
		Product  product = new Product();
		product.setProductId(productResponse.getProductId());
		product.setProductName(productResponse.getProductName());
		product.setProductPrice(productResponse.getProductPrice());
		product.setStatus(productResponse.getStatus());
		
		return product;
		
	}

	@Override
	public ProductResponse toProductResponse(Product product) {
		if(product == null) {
		return null;
		}
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductPrice(product.getProductPrice());
		productResponse.setStatus(product.getStatus());
		
		return productResponse;
	}

	@Override
	public List<ProductResponse> toProductsResponses(List<Product> products) {
		if(products == null) {
			return null;
		}
		
		List<ProductResponse> list = new ArrayList<ProductResponse>(products.size());
		for(Product product: products) {
			list.add(toProductResponse(product));
		}
		return list;
	}

	@Override
	public void updateProduct(Product product, ProductResponse productResponse) {
		if(productResponse == null) {
			return;
		}
		
		product.setProductId(productResponse.getProductId());
		product.setProductName(productResponse.getProductName());
		product.setProductPrice(productResponse.getProductPrice());
		product.setStatus(productResponse.getStatus());
		
		
	}


}
