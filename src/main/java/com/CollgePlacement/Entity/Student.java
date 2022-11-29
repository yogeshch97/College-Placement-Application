 package com.CollgePlacement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int studentId;
	private String studentName;
	private double studentBranch;
	private int studentPhone;
	private String studentMail;
	private int studenPercentage;
	private String companyName;
	private long studentPackage ;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int studentId, String studentName, double studentBranch, int studentPhone, String studentMail,
			int studenPercentage, String companyName, long studentPackage) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBranch = studentBranch;
		this.studentPhone = studentPhone;
		this.studentMail = studentMail;
		this.studenPercentage = studenPercentage;
		this.companyName = companyName;
		this.studentPackage = studentPackage;
	}
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getStudentBranch() {
		return studentBranch;
	}
	public void setStudentBranch(double studentBranch) {
		this.studentBranch = studentBranch;
	}
	public int getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(int studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentMail() {
		return studentMail;
	}
	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}
	public int getStudenPercentage() {
		return studenPercentage;
	}
	public void setStudenPercentage(int studenPercentage) {
		this.studenPercentage = studenPercentage;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getStudentPackage() {
		return studentPackage;
	}
	public void setStudentPackage(long studentPackage) {
		this.studentPackage = studentPackage;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentBranch=" + studentBranch
				+ ", studentPhone=" + studentPhone + ", studentMail=" + studentMail + ", studenPercentage="
				+ studenPercentage + ", companyName=" + companyName + ", studentPackage=" + studentPackage + "]";
	}
	
	
	
	
	
	
}
