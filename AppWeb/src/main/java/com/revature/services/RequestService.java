package com.revature.services;

import java.util.List;

import com.revature.models.Request;

public interface RequestService {
	
	public Request FindRequestById(int id);

	public Request findRequestByEmployeeId(int employeeId);
	
	public Request findRequestByManagerId(int employeeId);
	
	public List<Request> finAllRequests();
	
	public boolean editRequest(Request request);
	
	public boolean deleteRequest(Request request);
}
