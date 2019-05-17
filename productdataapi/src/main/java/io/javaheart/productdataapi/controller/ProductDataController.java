package io.javaheart.productdataapi.controller;

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

import io.javaheart.productdataapi.model.ProductData;
import io.javaheart.productdataapi.repository.ProductDataRepository;

@RestController
@RequestMapping("/")
public class ProductDataController {
	
	@Autowired
	ProductDataRepository pdrepo;
	
	@GetMapping("product")
	public List<ProductData> getAllProduct()
	{
		return pdrepo.findAll();
	}
	
	@GetMapping(path="product/{id}")
	public Optional<ProductData> getOneProduct(@PathVariable Integer id)
	{
		return pdrepo.findById(id);
	}
	
	@PostMapping("product")
	public ProductData addProduct(@Valid @RequestBody ProductData pd)
	{
		pdrepo.save(pd);
		return pd;
		
	}
	
	
	@PutMapping("product/{id}")
	public String updateProduct(@Valid @RequestBody ProductData pd,@PathVariable Integer id)
	{
		Optional<ProductData> st=pdrepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no. "+id;
		}
		else
		{
			ProductData s=st.get();
			s=pd;
			pdrepo.save(s);
			return "Data updated Successfully to ID no. "+id;
		}
	}
	
	@DeleteMapping("product/{id}")
	public String deleteProduct(@PathVariable Integer id)
	{
		Optional<ProductData> st=pdrepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no."+id;
		}
		else
		{
			pdrepo.deleteById(id);
			return "Product Id no. "+id+" Deleted";
		}
	}
	

}
