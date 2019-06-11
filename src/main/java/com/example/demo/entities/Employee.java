package com.example.demo.entities;

public class Employee {
	private Long empId;
	private String empNo;
	private String empName;

	public Employee() {

	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee(Long empId, String empNo, String empName) {
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
	}
}
