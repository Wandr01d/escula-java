package pe.com.stefanini.group.escuelajava.persistence.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByCustomerId(Integer customerId);


}
