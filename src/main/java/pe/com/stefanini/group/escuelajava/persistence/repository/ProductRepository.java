package pe.com.stefanini.group.escuelajava.persistence.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.stefanini.group.escuelajava.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Page<Product> findByProductNameAndStatus(String productName, Integer status, Pageable pageable);


}
