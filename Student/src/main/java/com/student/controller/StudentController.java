package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable(value = "id")Long sid)
	{
		return studentRepository.findById(sid).get();
	}
	
	@PostMapping("/student")
	public void createStudent(@Validated @RequestBody Student student)
	{
		studentRepository.save(student);
	}
	
	@PutMapping("/student/{id}")
	public Student updateStuent(@PathVariable(value = "id")Student sid, @RequestBody Student student)
	{
		Student students = studentRepository.save(sid);
		students.setName(student.getName());
		students.setEmail(student.getEmail());
		students.setPhoneNo(student.getPhoneNo());
		Student updateStuent = studentRepository.save(sid);
		return updateStuent;
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable(value = "id")Long sid)
	{
		studentRepository.deleteById(sid);
	}
}
