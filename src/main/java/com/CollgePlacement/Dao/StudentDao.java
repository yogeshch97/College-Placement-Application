package com.CollgePlacement.Dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.CollgePlacement.Entity.Student;



public interface StudentDao {

	
	
	public boolean saveStudent(Student student);

	public Student getStudentById(int studentId);
	
	
	public List<Student> getAllStudents();

	public boolean deleteStudent(int studentId);

	public boolean updateStudent(Student student);
	
	public List<Student> getMaxPackageStudents();
	
	public List<Student> sortStudentsById_ASC();

	public List<Student> sortStudentsByName_DESC();

	public double countSumOfStudentsPackage();

	public long getTotalCountOfStudents();
	
	
}
