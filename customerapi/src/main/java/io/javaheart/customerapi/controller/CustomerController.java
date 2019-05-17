package io.javaheart.customerapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javaheart.customerapi.model.Customer;
import io.javaheart.customerapi.repository.CustomerRepository;


@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerRepository curepo;
	
	@GetMapping("customer")
	public List<Customer> getAllCustomer()
	{
		return curepo.findAll();
	}
	
	@GetMapping(path="customer/{id}")
	public Optional<Customer> getOneCustomer(@PathVariable Integer id)
	{
		return curepo.findById(id);
	}
	
	@PostMapping("customer")
	public Customer addStudent(@Valid @RequestBody Customer cu)
	{
		curepo.save(cu);
		return cu;
		
	}
	
	
	@PutMapping("customer/{id}")
	public String updateStudent(@Valid @RequestBody Customer cu,@PathVariable Integer id)
	{
		Optional<Customer> st=curepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no. "+id;
		}
		else
		{
			Customer s=st.get();
			s=cu;
			curepo.save(s);
			return "Data updated Successfully to ID no. "+id;
		}
	}
	
	@DeleteMapping("customer/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		Optional<Customer> st=curepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no."+id;
		}
		else
		{
			curepo.deleteById(id);
			return "Customer Id no. "+id+" Deleted";
		}
	}
	

}
