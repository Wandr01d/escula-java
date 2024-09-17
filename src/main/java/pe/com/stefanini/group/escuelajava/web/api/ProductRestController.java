package pe.com.stefanini.group.escuelajava.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.stefanini.group.escuelajava.model.response.ProductResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Product;
import pe.com.stefanini.group.escuelajava.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
    public Page<Product> getAllProducts(
            @RequestParam(required = false, defaultValue = "0") String productName,
            @RequestParam(required = false, defaultValue = "5") Integer status,
            Pageable pageable) {
        return productService.findByProductNameAndStatusPage(productName, status, pageable);
    }
	
	@GetMapping("/products/prueba")
	public ResponseEntity<List<ProductResponse>> findAllProductToPage(){
		return new ResponseEntity<>(productService.findAllProductToPage(),HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductResponse> findByProductId(@PathVariable("productId")Integer productId){
		return new ResponseEntity<>(productService.findByProductId(productId),HttpStatus.OK);
	}
	
	@PostMapping("/products/save")
	public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductResponse productResponse){
		return new ResponseEntity<>(productService.saveProduct(productResponse),HttpStatus.CREATED);
	}
	
	@PutMapping("/products/update/{productId}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable("productId")Integer productId, @RequestBody ProductResponse productResponse){
		return new ResponseEntity<>(productService.updateProduct(productId, productResponse),HttpStatus.OK);
	}

}
