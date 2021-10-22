package com.tcs.business;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Employee;
import com.tcs.dao.EmployeeDao;
import com.tcs.exception.EmployeeNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public Employee store(Employee employee) {
		int result = employeeDao.save(employee);
		Employee emp = employeeDao.fetchEmployee(result);
		return emp;
	}

	@Override
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
		Employee emp = employeeDao.fetchEmployee(id);
		if(emp == null) {
			throw new EmployeeNotFoundException("Sorry "+id+" not found!");
		}
		// returns only if employee found
		return emp;
	}
	// Assignment
	@Override
	@Transactional
	public Employee updateEmployeeSalary(int id, double salary) throws EmployeeNotFoundException {
		Employee e= findEmployeeById(id);
		e.setSalary(salary);
		employeeDao.updateEmployee(e, id);
		if(e == null) {
			throw new EmployeeNotFoundException("Sorry "+id+" not found!");
		}
		// returns only if employee found
		return e;
	}
	// Assignment
	@Override
	@Transactional
	public Employee updateEmployeeName(int id, String name) throws EmployeeNotFoundException {
		Employee e= findEmployeeById(id);
		e.setName(name);
		employeeDao.updateEmployee(e, id);
		if(e == null) {
			throw new EmployeeNotFoundException("Sorry "+id+" not found!");
		}
		// returns only if employee found
		return e;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.fetchEmployees();
	}

	// Assignment
	@Override
	public List<Employee> getEmployeesOrderByName() {
		List<Employee> empl = getEmployees();
		Collections.sort(empl, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				
				return e1.getName().compareTo(e2.getName());
			}
			
		});
		return empl;
	}

}
