package com.example.StudentProvider.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.StudentProvider.controllers.Student;



@Service
public class StudentServices {

	@Autowired
	StudentDAO sdao;
	
	// inset student DETAILS
	public String SaveDetails( Student stu) {
		
		System.out.println("Student Details  --->"+stu.getId()+"  "+stu.getName()+"  "+stu.getPlace()+"  "+stu.getEmail()+"  "+stu.getSalary());
		
		try {
			
			 sdao.save(stu);
			
			
		}catch(Exception e) { System.out.println("Exception occured in Service layer saveDetails()-->"); 
		
		
		return "Student Details not Saved";
		}
		
		
		return  "Student details have Save Sucessfully in database";
	}
	
	
	//uPDATE sTUDENT dETAILS
	
	public String updateDetails( Student stu) {
		
		
		Optional<Student> s1 =sdao.findById(stu.getId());
		
		
		Student s = s1.get();
		
		s.setName(stu.getName());
		s.setPlace(stu.getPlace());
		s.setEmail(stu.getEmail());
		s.setSalary(stu.getSalary());
		try {
		sdao.save(s);
		}catch(Exception e) { System.out.println("Exception Occured--->");
		
		return "Student Details not updated";
		}
		return    "Student details  update Sucessfully";
	}
	
	//sTUDENT Delete 
	
	public String deleteDetails(int id) {
		try {
//	Student s =	sdao.getOne(id);
			boolean b = sdao.existsById(id);
			if(b) {
				System.out.println("______________________________"+b);
			}
			else {
				System.out.println("_____________________"+b);
				return   " Student id"+id+"  not avallabe in my database please provide valid details";
			}
	System.out.println("---------------------");
	    sdao.deleteById(id);
		
		}catch(Exception e) {  System.out.println("Exception in delete Student Details");
		return " Student id"+id+"  not deteted  in my database";
		}
		
	
	
		return "Student with  "+id+"   id has Sucessfully Deleted From database";
	}
	
	
	//get All Student Details
	
	public List<Student> getDetails(){
		
		List<Student> al=null;
		try {
			
			al= sdao.findAll();
			
			
		}catch(Exception E) {
			
			System.out.println("Exception occured in getall Student detyails");
			
		}
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
