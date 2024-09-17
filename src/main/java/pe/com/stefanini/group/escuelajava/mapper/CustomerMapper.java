package pe.com.stefanini.group.escuelajava.mapper;

import java.util.List;

import pe.com.stefanini.group.escuelajava.model.response.CustomerResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;



public interface CustomerMapper {
	
	Customer toCustomer(CustomerResponse customerResponse);
	
	CustomerResponse toCustomerResponse(Customer customer);
	
	List<CustomerResponse> toCustomersResponses(List<Customer> customer);
	
	void updateCustomer(Customer customer, CustomerResponse customerResponse);
}
