package io.javaheart.studentapi.controller;

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

import io.javaheart.studentapi.model.Student;
import io.javaheart.studentapi.repository.StudentRepository;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	StudentRepository stdrepo;
	
	@GetMapping("student")
	public List<Student> getAllStudent()
	{
		return stdrepo.findAll();
	}
	
	@GetMapping(path="student/{id}")
	public Optional<Student> getOneStudent(@PathVariable Integer id)
	{
		return stdrepo.findById(id);
	}
	
	@PostMapping("student")
	public Student addStudent(@Valid @RequestBody Student stu)
	{
		stdrepo.save(stu);
		return stu;
		
	}
	
	
	@PutMapping("student/{id}")
	public String updateStudent(@Valid @RequestBody Student stu,@PathVariable Integer id)
	{
		Optional<Student> st=stdrepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no. "+id;
		}
		else
		{
			Student s=st.get();
			s=stu;
			stdrepo.save(s);
			return "Data updated Successfully to ID no. "+id;
		}
	}
	
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		Optional<Student> st=stdrepo.findById(id);
		if(!st.isPresent())
		{
			return "Invalid ID no."+id;
		}
		else
		{
			stdrepo.deleteById(id);
			return "Student Id no. "+id+" Deleted";
		}
	}
	

}
