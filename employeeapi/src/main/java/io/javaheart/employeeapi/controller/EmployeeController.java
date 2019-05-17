package io.javaheart.employeeapi.controller;

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

import io.javaheart.employeeapi.model.Employee;
import io.javaheart.employeeapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("employee")
	public List<Employee> getAllEmployee()
	{
		return emprepo.findAll();
	}
	
	@GetMapping(path="employee/{id}")
	public Optional<Employee> getOneEmployee(@PathVariable Integer id)
	{
		return emprepo.findById(id);
	}
	
	@PostMapping("employee")
	public Employee addEmployee(@Valid @RequestBody Employee emp)
	{
		emprepo.save(emp);
		return emp;
		
	}
	
	
	@PutMapping("employee/{id}")
	public String updateEmployee(@Valid @RequestBody Employee emp,@PathVariable Integer id)
	{
		Optional<Employee> st=emprepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no. "+id;
		}
		else
		{
			Employee s=st.get();
			s=emp;
			emprepo.save(s);
			return "Data updated Successfully to ID no. "+id;
		}
	}
	
	@DeleteMapping("employee/{id}")
	public String deleteEmployee(@PathVariable Integer id)
	{
		Optional<Employee> st=emprepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no."+id;
		}
		else
		{
			emprepo.deleteById(id);
			return "Employee Id no. "+id+" Deleted";
		}
	}
	

}
