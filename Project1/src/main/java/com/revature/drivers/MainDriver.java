package com.revature.drivers;

import java.time.LocalDate;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.ManagerDAO;
import com.revature.dao.RequestDAO;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Request;

public class MainDriver {
	private static Logger logger = Logger.getLogger(MainDriver.class);

	static EmployeeDAO edao = new EmployeeDAO();
	static ManagerDAO mdao = new ManagerDAO();
	static RequestDAO rdao = new RequestDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee employee = new Employee("uName", "pa55Word", "Bob", "Smith", "email@email.com");
		Employee employee2 = new Employee("uName2", "pa55Word", "Bob", "Smith", "email2@email.com");
		Employee employee3 = new Employee("uName3", "pa55Word", "Bob", "Smith", "email3@email.com");
		Employee employee4 = new Employee("uName4", "pa55Word", "Bob", "Smith", "email4@email.com");
		Employee employee5 = new Employee("uName5", "pa55Word", "Bob", "Smith", "email5@email.com");

		edao.insert(employee);
		edao.insert(employee2);
		edao.insert(employee3);
		edao.insert(employee4);
		edao.insert(employee5);
		
		Manager manager = new Manager("ManUName", "ManPa55", "John", "Doe", "ManEmail@email.com");
		Manager manager2 = new Manager("ManUName2", "ManPa55", "John", "Doe", "ManEmail2@email.com");
		Manager manager3 = new Manager("ManUName3", "ManPa55", "John", "Doe", "ManEmail3@email.com");
		Manager manager4 = new Manager("ManUName4", "ManPa55", "John", "Doe", "ManEmail4@email.com");
		Manager manager5 = new Manager("ManUName5", "ManPa55", "John", "Doe", "ManEmail5@email.com");
		
		mdao.insert(manager);
		mdao.insert(manager2);
		mdao.insert(manager3);
		mdao.insert(manager4);
		mdao.insert(manager5);
		
		LocalDate subDate = LocalDate.now();
		
		Request reqeust = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 1 - 1", "Food", 0, 0);
		Request reqeust2 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 2 - 2", "Food2", 1, 1);
		Request reqeust3 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 3 - 3", "Food3", 2, 2);
		Request reqeust4 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 4 - 4", "Food4", 3, 3);
		Request reqeust5 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 5 - 5", "Food5", 4, 4);
		Request reqeust6 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 5 - 1", "Food", 4, 0);
		Request reqeust7 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 4 - 2", "Food2", 3, 1);
		Request reqeust8 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 3 - 3", "Food3", 2, 2);
		Request reqeust9 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 2 - 4", "Food4", 1, 3);
		Request reqeust10 = new Request(1.12, subDate , "Submitted", "Meal receipt from trip 1 - 5", "Food5", 0, 4);
		
		
		

		employee5.setEmployeeId(5);
		employee5.setUserName("uName55");
		edao.update(employee5);

		System.out.println(edao.selectAll());
		System.out.println(mdao.selectAll());
		System.out.println(rdao.SelectAll());
		
		
		System.out.println(edao.selectById(2));
		System.out.println(mdao.selectById(2));
		System.out.println(rdao.selectById(2));
	}
	
	/*
	 * Employee log in
	 * */
	public static Employee employeeSignIn(String uName, String password, String email) {
		// if uName exists
		Employee employee = edao.selectByUName(uName);
		
		return employee;
	}

}
