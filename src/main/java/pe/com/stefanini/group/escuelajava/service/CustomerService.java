package pe.com.stefanini.group.escuelajava.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.com.stefanini.group.escuelajava.model.response.CustomerResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;

public interface CustomerService {
	
	Page<Customer> findAllCustomersToPage(Pageable pageRequest);
	CustomerResponse findByCustomerId(Integer customerId);
	CustomerResponse saveCustomer(CustomerResponse customerResponse);
	CustomerResponse updateCustomer(Integer customerId, CustomerResponse customerResponse);
}
