package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

public class RequestHelper {

	private static EmployeeService eserv= new EmployeeServiceImpl(new EmployeeDAOImpl());
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		log.info("In Request Helper getting all Employees....");
		// 1. set the content type to return JSON to the browser
		resp.setContentType("application/json");
		
		// 2. get a list of all users in the database
		List<Employee> allEmployee = eserv.findAllEmployees();
		
		// 3. turn that list of java objects into a JSON string (using Jackson)
		String json = om.writeValueAsString(allEmployee);
		
		// 4. use a PrintWriter to write the objects to the response body which will be seen in the browser
		PrintWriter pw = resp.getWriter();
		pw.println(json);
		log.info("Leaving RequestHelper");
	}

	public static void processUserBySearchParam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		log.info("In RequestHelper. Searching by para");
		BufferedReader br = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		//We are just transferring our reader data into our stringBuilder object, line by line.
		String line = br.readLine();
		while(line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		String body = sb.toString();
		// here I will extract all of the unneeded param symbols from the body
		// in request body:
		// username=bob&password=123&firstname=bob&....
		// so just removing & marks!
		log.info("Employee search with this info: " + body);
		String[] sepByAmp = body.split("&");
		List<String> values = new ArrayList<String>();
		for(String pair : sepByAmp) { // each element in array look like key-value pairs
			values.add(pair.substring(pair.indexOf("=")+1)); // trim each String element in the array to just value -> bob, 123, bob, etc...
		}
		// determine what type of search we are doing.
		if(body.startsWith("id")) {
			log.info("In RequestHelper. Getting user by id....");
			// 1. set the content type to return JSON to the browser
			resp.setContentType("application/json");
			
			// 2. get employee from database
			int id = Integer.parseInt(values.get(0));
			Employee employee = eserv.findEmployeeById(id);
			// 3. turn that list of java objects into a JSON string (using Jackson)
			String json = om.writeValueAsString(employee);
			
			// 4. use a PrintWriter to write the objects to the response body which will be seen in the browser
			PrintWriter pw = resp.getWriter();
			pw.println(json);
			log.info("Leaving RequestHelper");
		} else if (body.startsWith("firstname")) {
			log.info("In RequestHelper getting Employee by first name...");
			// 1. set the content type to return JSON to the browser
			resp.setContentType("application/json");
			
			// 2. get a list of all users in the database
			String firstName = values.get(0);
			Employee employee = eserv.findEmployeeByUserName(firstName);
			// 3. turn that list of java objects into a JSON string (using Jackson)
			String json = om.writeValueAsString(employee);
			
			// 4. use a PrintWriter to write the objects to the response body which will be seen in the browser
			PrintWriter pw = resp.getWriter();
			pw.println(json);
			log.info("Leaving RequestHelper");
		}
		
	}

	public static void processRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("inside of RequestHelper...processRegistration...");
		BufferedReader reader = request.getReader();
		StringBuilder s = new StringBuilder();

		// we are just transferring our Reader data to our StringBuilder, line by line
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString(); 
		String [] sepByAmp = body.split("&"); // separate username=bob&password=pass -> [username=bob, password=pass]
		
		List<String> values = new ArrayList<String>();
		
		for (String pair : sepByAmp) { // each element in array looks like this
			values.add(pair.substring(pair.indexOf("=") + 1)); // trim each String element in the array to just value -> [bob, pass]
		}
		log.info("User attempted to register with information:\n " + body);
		// capture the actual username and password values
		String username = values.get(0); // bob
		String password = values.get(1); // pass
		String firstname = values.get(2);
		String lastname = values.get(3);
		String email = values.get(4);
		
		Employee e = new Employee(username, password, firstname, lastname, email);
		int targetId = eserv.register(e);

		if (targetId != 0) {
			PrintWriter pw = response.getWriter();
			e.setEmployeeId(targetId);
			log.info("New user: " + e);
			String json = om.writeValueAsString(e);
			pw.println(json);
			System.out.println("JSON:\n" + json);
			
			response.setContentType("application/json");
			response.setStatus(200); // SUCCESSFUL!
			log.info("User has successfully been created.");
		} else {
			response.setContentType("application/json");
			response.setStatus(204); // this means that the connection was successful but no user created!
		}
		log.info("leaving request helper now...");
	}
}



















// stuff

