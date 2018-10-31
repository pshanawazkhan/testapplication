package com.example.StudentProvider.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentProvider.dao.StudentServices;

@RestController
@RequestMapping(value="/student")
public class StudentController {

	@Autowired
	StudentServices ss;
	
	
	@RequestMapping("/getDetails")
	public List<Student> getAllStudentDetails() {
		
		
		List<Student> result =  ss.getDetails(); 
		
		return result;
	}
	
	@PostMapping("/save")
	public String saveStudentDetails( @RequestBody Student stu) {
		
		
		String result = ss.SaveDetails(stu);
		
		return result;
	}
	
	
	@PutMapping("/udate")
	public String updatedStudentDetails( @RequestBody  Student stu) {
		
		String result = ss.updateDetails(stu);
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteStudentDetails(@PathVariable("id" )   int id) {
		
		String result= ss.deleteDetails(id);
		
		return result;
	}
	
	
	
}
