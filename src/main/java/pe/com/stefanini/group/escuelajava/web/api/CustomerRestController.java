package pe.com.stefanini.group.escuelajava.web.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import pe.com.stefanini.group.escuelajava.model.response.CustomerResponse;
import pe.com.stefanini.group.escuelajava.persistence.entity.Customer;
import pe.com.stefanini.group.escuelajava.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<Page<Customer>> getAllCustomersToPage(
			@RequestParam(required = false, name = "page", defaultValue = "0") Integer page, 
			@RequestParam(required = false, name= "size", defaultValue = "5") Integer size){
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Customer> customers = customerService.findAllCustomersToPage(pageable);
		
		return ResponseEntity.ok(customers);
	}
	
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerId(@PathVariable("customerId")Integer customerId){
		CustomerResponse customers = customerService.findByCustomerId(customerId);
		return ResponseEntity.ok(customers);
	}
	
	@PostMapping("/customers/save")
	public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody CustomerResponse customerResponse) {
	    return new ResponseEntity<>(customerService.saveCustomer(customerResponse),HttpStatus.CREATED);
	 }
	
	@PutMapping("/customers/update/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("customerId")Integer customerId, @RequestBody CustomerResponse customerResponse){
		return new ResponseEntity<>(customerService.updateCustomer(customerId, customerResponse),HttpStatus.OK);
	}
	

}

