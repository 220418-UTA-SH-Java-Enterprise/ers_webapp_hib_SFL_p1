package com.revature.drivers;

import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;

public class EmployeeDriver {

	private static EmployeeDAO edao = new EmployeeDAO();
	
	Employee employee = new Employee("uName", "pa55Word", "Bob", "Smith", "email@email.com");
	Employee employee2 = new Employee("uName2", "pa55Word", "Bob", "Smith", "email2@email.com");
	Employee employee3 = new Employee("uName3", "pa55Word", "Bob", "Smith", "email3@email.com");
	Employee employee4 = new Employee("uName4", "pa55Word", "Bob", "Smith", "email4@email.com");
	Employee employee5 = new Employee("uName5", "pa55Word", "Bob", "Smith", "email5@email.com");

	
	
//	
//	edao.insert(employee);
//	edao.insert(employee2);
//	edao.insert(employee3);
//	edao.insert(employee4);
//	edao.insert(employee5);
	public int insert(Employee employee) {
		return edao.insert(employee);
	}
}
