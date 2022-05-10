package com.revature.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAO {

	public void insertWithoutCasting(Employee employee) {
		// capture a session
		Session ses = HibernateUtil.getSession();

		// Transaction is uniquely from Hibernate
		Transaction tx = ses.beginTransaction();

		// The save() method returns the PK
		ses.save(employee);
		tx.commit();
	}

	public int insert(Employee employee) {
		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(employee);

		tx.commit();

		return pk;
	}

	public List<Employee> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Employee> employeeList = ses.createQuery("from Employee", Employee.class).list();

		return employeeList;

	}
	
	public Employee selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Employee employee = ses.get(Employee.class, id);
		
		return employee;
	}
	
	public void update(Employee employee) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(employee);
		tx.commit();
	}
	
	public void delete(Employee employee) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(employee);
		tx.commit();
	}
	
	public Employee selectByUName(String uName) {
		Session ses = HibernateUtil.getSession();
		Employee employee = (Employee) ses.createQuery("from Employee where userName = " + uName, Employee.class);
		return employee;
	}
	
	
}
