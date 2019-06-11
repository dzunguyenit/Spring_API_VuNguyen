package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository
public class EmployeeDAO {

	private static final Map<Long, Employee> empMap = new HashMap<Long, Employee>();

	static {
		initEmps();
	}

	private static void initEmps() {

		Employee employee1 = new Employee(1L, "Employee 1", "Xuân Nguyễn");
		Employee employee2 = new Employee(2L, "Employee 2", "My Nguyễn");
		Employee employee3 = new Employee(3L, "Employee 3", "Mai Nguyễn");
		Employee employee4 = new Employee(4L, "Employee 4", "Trí Nguyễn");
		Employee employee5 = new Employee(5L, "Employee 5", "Vũ Nguyễn");
		Employee employee6 = new Employee(6L, "Employee 6", "Như Nguyễn");
		empMap.put(employee1.getEmpId(), employee1);
		empMap.put(employee2.getEmpId(), employee2);
		empMap.put(employee3.getEmpId(), employee3);
		empMap.put(employee4.getEmpId(), employee4);
		empMap.put(employee5.getEmpId(), employee5);
		empMap.put(employee6.getEmpId(), employee6);
	}

	public Long getMaxEmpId() {
		Set<Long> keys = empMap.keySet();
		Long max = 0L;
		for (Long key : keys) {
			if (key > max) {
				max = key;

			}
		}
		return max;
	}

	public Employee getEmployee(Long empId) {
		return empMap.get(empId);
	}

	public Employee addEmployee(Employee empForm) {
		Long empId = this.getMaxEmpId() + 1;
		empForm.setEmpId(empId);
		empMap.put(empForm.getEmpId(), empForm);
		return empForm;
	}

	public Employee updateEmployee(Employee empForm) {
		Employee empUpdate = this.getEmployee(empForm.getEmpId());
		if (empUpdate != null) {
			empUpdate.setEmpNo(empForm.getEmpNo());
			empUpdate.setEmpName(empForm.getEmpName());
		}
		return empUpdate;
	}

	public void deleteEmployee(Long empId) {
		empMap.remove(empId);
	}

	public List<Employee> getAllEmployees() {
		Collection<Employee> collection = empMap.values();
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(collection);
		return list;
	}
}
