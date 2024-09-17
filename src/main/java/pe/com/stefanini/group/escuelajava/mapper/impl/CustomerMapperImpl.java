package pe.com.stefanini.group.escuelajava.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.stefanini.group.escuelajava.mapper.CustomerMapper;
import pe.com.stefanini.group.escuelajava.model.response.CustomerResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;

@Component
public class CustomerMapperImpl  implements CustomerMapper{

	@Override
	public Customer toCustomer(CustomerResponse customerResponse) {
		if(customerResponse == null) {
			return null;
		}
		Customer customer = new Customer();
		customer.setCustomerId(customerResponse.getCustomerId());
		customer.setCustomerName(customerResponse.getCustomerName());
		customer.setCustomerAddress(customerResponse.getCustomerAddress());
		customer.setDocumentType(customerResponse.getDocumentType());
		customer.setDocumentNumber(customerResponse.getDocumentNumber());
		
		return customer;
		
	}

	@Override
	public CustomerResponse toCustomerResponse(Customer customer) {
		if(customer == null) {
			return null;
		}
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomerId(customer.getCustomerId());
		customerResponse.setCustomerName(customer.getCustomerName());
		customerResponse.setCustomerAddress(customer.getCustomerAddress());
		customerResponse.setDocumentType(customer.getDocumentType());
		customerResponse.setDocumentNumber(customer.getDocumentNumber());
		
		return customerResponse;
		
	}

	@Override
	public List<CustomerResponse> toCustomersResponses(List<Customer> customers) {
		if(customers == null) {
			return null;
		}
		
		List<CustomerResponse> list = new ArrayList<CustomerResponse>(customers.size());
		for(Customer customer: customers) {
			list.add(toCustomerResponse(customer));			
		}
		return list;
	}

	@Override
	public void updateCustomer(Customer customer, CustomerResponse customerResponse) {
		if(customerResponse == null) {
			return;
		}
		
		customer.setCustomerId(customerResponse.getCustomerId());
		customer.setCustomerName(customerResponse.getCustomerName());
		customer.setCustomerAddress(customerResponse.getCustomerAddress());
		customer.setDocumentType(customerResponse.getDocumentType());
		customer.setDocumentNumber(customerResponse.getDocumentNumber());
		
		
	}

}
