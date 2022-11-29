package com.CollgePlacement.Dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.CollgePlacement.Entity.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveStudent(Student student) {
		Session session= sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student2 = session.get(Student.class, student.getStudentId());
		session.save(student);
		transaction.commit();
		
		
		return true;
	}
	

	@Override
	public Student getStudentById(int studentId) {
		Session session = sessionFactory.openSession();
		Student student = null;
		try {
			student = session.get(Student.class, studentId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return student;
	}
//
	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {

		
			Criteria criteria = session.createCriteria(Student.class);

			criteria.addOrder(Order.asc("StudentName"));

			list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Student student = session.get(Student.class, studentId);
			if (student != null) {
				session.delete(student);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Student stu = session.get(Student.class, student.getStudentId());
			session.evict(stu);
			if (stu != null) {
				session.update(student);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getMaxPackageStudents() {
		Session session = sessionFactory.openSession();

		List<Student> maxPackage = null;
		try {
			Criteria maxcriteria = session.createCriteria(Student.class);
			Criteria eqcriteria = session.createCriteria(Student.class);
			maxcriteria.setProjection(Projections.max("studentPackage"));
			List<Student> list = maxcriteria.list();
			maxPackage = (List<Student>) list.get(0);

			eqcriteria.add(Restrictions.eq("studentPackage", maxPackage));
			List maxPackage1 = eqcriteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return maxPackage;
	}

	@Override
	public List<Student> sortStudentsById_ASC() {
		Session session = sessionFactory.openSession();
		List<Student> sortedList = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.asc("studentId"));
			sortedList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return sortedList;
	}

	@Override
	public List<Student> sortStudentsByName_DESC() {
		Session session = sessionFactory.openSession();
		List<Student> sortedList = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.desc("studentName"));
			sortedList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return sortedList;
	}

	@Override
	public double countSumOfStudentsPackage() {
		Session session = sessionFactory.openSession();
		double countSumOfStudentsPackage = 0;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.sum("studentPackage"));

			List<Double> list = criteria.list();
			if (!list.isEmpty()) {
				countSumOfStudentsPackage = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return countSumOfStudentsPackage();
	}

	@Override
	public long getTotalCountOfStudents() {
		Session session = sessionFactory.openSession();
		long countOfStudentsPackage = 0;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				countOfStudentsPackage = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return countOfStudentsPackage;
	}

}
