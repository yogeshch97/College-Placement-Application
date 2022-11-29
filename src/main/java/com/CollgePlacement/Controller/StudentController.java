package com.CollgePlacement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CollgePlacement.Entity.Student;
import com.CollgePlacement.Service.StudentService;


@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping(value = "/save_student")
	public ResponseEntity<Boolean> saveStudent(@RequestBody Student student){
		boolean saveStudnet = service.saveStudent(student);
		if (saveStudnet) {
			return new ResponseEntity<Boolean>(saveStudnet, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Boolean>(saveStudnet, HttpStatus.BAD_REQUEST);
		}
	}
	



	@GetMapping(value = "/get_student_by_id/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
		Student student = service.getStudentById(studentId);
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<Student>(HttpStatus.OK);
		}

	}
	

	@GetMapping(value = "/get_all_students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = service.getAllStudents();
		if (!allStudents.isEmpty()) {
			return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}

	}

	@DeleteMapping(value = "/delete_student")
	public ResponseEntity<Boolean> getAllStudents(@RequestParam int studentId) {
		boolean isDeleted = service.deleteStudent(studentId);

		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);

	}

	@PutMapping(value = "/update_student")
	public ResponseEntity<Boolean> updateStudent( @RequestBody Student student) {

		boolean isUpdated = service.updateStudent(student);

		return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);

	}

	
	
	///////////////////////////////////////////////
	
	@GetMapping(value = "/sort_students_by_id_asc")
	public ResponseEntity<List<Student>> sortStudentsById_ASC() {
		List<Student > sortedList = service.sortStudentsById_ASC();
		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Student>>(sortedList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}

	} 
	
	@GetMapping(value = "/sort_students_by_name_DESC")
	public ResponseEntity<List<Student>> sortStudentsByName_DESC() {
		List<Student> sortedList = service.sortStudentsByName_DESC();
		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Student>>(sortedList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}

	} 
	
	@GetMapping(value = "/get_max_packagae_students")
	public ResponseEntity<List<Student>> getMaxPackageStudents() {

		List<Student> getMaxPakageStudents = service.getMaxPackageStudents();

		return new ResponseEntity<List<Student>>(getMaxPakageStudents, HttpStatus.OK);

	}
	
	@GetMapping(value = "/count_sum_of_student_package")
	public ResponseEntity<Double> countSumOfStudentPackage() {

		double sumOfStudents = service.countSumOfStudentsPackage();

		return new ResponseEntity<Double>(sumOfStudents, HttpStatus.OK);

	}
	
	@GetMapping(value = "/get_total_count_of_students")
	public ResponseEntity<Long> getTotalCountOfStudents() {

		long countOfStudents = service.getTotalCountOfStudents();

		return new ResponseEntity<Long>(countOfStudents, HttpStatus.OK);

	}
	
	

}
