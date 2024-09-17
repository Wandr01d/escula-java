package pe.com.stefanini.group.escuelajava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.stefanini.group.escuelajava.mapper.CustomerMapper;
import pe.com.stefanini.group.escuelajava.model.response.CustomerResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;
import pe.com.stefanini.group.escuelajava.persistence.repository.CustomerRepository;
import pe.com.stefanini.group.escuelajava.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> findAllCustomersToPage(Pageable pageable) {
		// TODO Auto-generated method stub

		Page<Customer> customers = customerRepository.findAll(pageable);

		return customers;
	}

	@Override
	public CustomerResponse findByCustomerId(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		return customerMapper.toCustomerResponse(customer);
	}

	@Override
	public CustomerResponse saveCustomer(CustomerResponse customerResponse) {
		Customer customer = customerMapper.toCustomer(customerResponse);
		return customerMapper.toCustomerResponse(customerRepository.save(customer));
	}

	@Override
	public CustomerResponse updateCustomer(Integer customerId, CustomerResponse customerResponse) {
		Customer customer = customerRepository.findById(customerId).get();
		customerMapper.updateCustomer(customer, customerResponse);
		return customerMapper.toCustomerResponse(customerRepository.save(customer));

	}

}
