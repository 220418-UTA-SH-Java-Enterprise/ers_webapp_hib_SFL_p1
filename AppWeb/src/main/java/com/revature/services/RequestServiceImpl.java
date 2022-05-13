package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.RequestDAO;
import com.revature.dao.RequestDAOImpl;
import com.revature.models.Request;

public class RequestServiceImpl implements RequestService {
	
	public RequestServiceImpl(RequestDAOImpl dao) {
		super();
		this.rdao = dao;
	}
	
	private RequestDAO rdao;
	private static Logger log = Logger.getLogger(RequestServiceImpl.class);

	@Override
	public Request FindRequestById(int id) {
		log.info("In service layer. Finding Request by id: " + id + "." );
		return rdao.selectById(id);
	}

	@Override
	public Request findRequestByEmployeeId(int employeeId) {
		log.info("In service layer. Finding Request by employee id: " + employeeId + "." );
		return rdao.selectById(employeeId);
	}

	@Override
	public Request findRequestByManagerId(int managerId) {
		log.info("In service layer. Finding Request by manger id: " + managerId + "." );
		return rdao.selectById(managerId);
	}

	@Override
	public List<Request> finAllRequests() {
		log.info("In service layer. Finding  all Requests." );
		return rdao.selectAll();
	}

	@Override
	public boolean editRequest(Request request) {
		log.info("In service layer. Edit Employee: " + request + "." );
		return rdao.update(request);
	}

	@Override
	public boolean deleteRequest(Request request) {
		log.info("In service layer. Delete Employee: " + request + "." );
		return rdao.delete(request);
	}

}
