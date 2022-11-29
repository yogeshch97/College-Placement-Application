package com.CollgePlacement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.CollgePlacement.Dao.StudentDao;
import com.CollgePlacement.Entity.Student;

@Component
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentDao  dao;
	
	
	@Override
	public boolean saveStudent(Student student) {
		
		dao.saveStudent(student);
		return true;
	}

	@Override
	public Student getStudentById(int studentId) {

		return dao.getStudentById(studentId);
	}

	@Override
	public List<Student> getAllStudents() {

		return dao.getAllStudents();
	}

	@Override
	public boolean deleteStudent(int studentId) {

		return dao.deleteStudent(studentId);
	}

	@Override
	public boolean updateStudent(Student student) {

		return dao.updateStudent(student);
	}

	@Override
	public List<Student> getMaxPackageStudents() {

		return dao.getMaxPackageStudents();
	}

	@Override
	public List<Student> sortStudentsById_ASC() {

		return dao.sortStudentsById_ASC();
	}

	@Override
	public List<Student> sortStudentsByName_DESC() {

		return dao.sortStudentsByName_DESC();
	}

	@Override
	public double countSumOfStudentsPackage() {

		return dao.countSumOfStudentsPackage();
	}

	@Override
	public long getTotalCountOfStudents() {

		return dao.getTotalCountOfStudents();
	}

}
