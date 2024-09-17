package pe.com.stefanini.group.escuelajava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.stefanini.group.escuelajava.mapper.ProductMapper;
import pe.com.stefanini.group.escuelajava.model.response.ProductResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Product;
import pe.com.stefanini.group.escuelajava.persistence.repository.ProductRepository;
import pe.com.stefanini.group.escuelajava.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductResponse> findAllProductToPage() {
		return productMapper.toProductsResponses(productRepository.findAll());
	}

	@Override
	public ProductResponse findByProductId(Integer productId) {
		Product product = productRepository.findById(productId).get();
		return productMapper.toProductResponse(product);
	}

	@Override
	public ProductResponse saveProduct(ProductResponse productResponse) {
		Product product = productMapper.toProduct(productResponse);
		return productMapper.toProductResponse(productRepository.save(product));
	}

	@Override
	public ProductResponse updateProduct(Integer productId, ProductResponse productResponse) {
		Product product = productRepository.findById(productId).get();
		productMapper.updateProduct(product, productResponse);
		return productMapper.toProductResponse(productRepository.save(product));
	}

	@Override
	public Page<Product> findByProductNameAndStatusPage(String productName, Integer status, Pageable pageable) {
		return productRepository.findByProductNameAndStatus(productName, status, pageable);
	}

}
