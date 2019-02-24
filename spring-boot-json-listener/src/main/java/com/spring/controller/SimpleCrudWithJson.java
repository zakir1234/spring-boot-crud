
package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.dto.StudentDTO;
import com.spring.service.StudentService;

@RestController
@RequestMapping("/student/")
public class SimpleCrudWithJson {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ServletContext servletContext;
		
	@PostMapping(path="save-or-update")
	public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO) {
		
		studentService.saveOrUpdateStudent(studentDTO);		
		return new ResponseEntity<String>("Student Saved Successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("find-all")
	public ResponseEntity<List<StudentDTO>> saveStudent() {
		return new ResponseEntity<List<StudentDTO>>(studentService.findAllStudents(), HttpStatus.OK);		
	}
	
	
	@GetMapping("find/by/id")
	public ResponseEntity<StudentDTO> editStudent(@RequestParam Long studentId) {
	 
		return new ResponseEntity<StudentDTO>(studentService.findByStudentID(studentId), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/by/id")
	public ResponseEntity<String> deleteStudent(@RequestParam Long studentId) {		
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);		
	}
	
}
