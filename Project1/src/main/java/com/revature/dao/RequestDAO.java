package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Request;
import com.revature.util.HibernateUtil;

public class RequestDAO {
	
	public void insertwithoutCasting(Request request) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(request);
		tx.commit();
	}
	
	public int insert(Request request) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(request);

		tx.commit();
		return pk;
	}

	public List<Request> SelectAll() {
		Session ses = HibernateUtil.getSession();
		List<Request> requestList = ses.createQuery("from Request", Request.class).list();

		return requestList;

	}
	
	public Request selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Request request = ses.get(Request.class, id);
		return request;
	}

	public List<Request> selectByEmployeeId(int employeeId) {
		Session ses = HibernateUtil.getSession();

		List<Request> requestListByEmpId = ses
				.createQuery("from Request where employeeId = " + employeeId, Request.class).list();

		return requestListByEmpId;
	}
	
	public List<Request> selectByManagerId(int managerId) {
		Session ses = HibernateUtil.getSession();

		List<Request> requestListByEmpId = ses
				.createQuery("from Request where employeeId = " + managerId, Request.class).list();

		return requestListByEmpId;
	}

	public List<Request> selectByReimbursmentStatus(String reimbursmentStatus) {
		Session ses = HibernateUtil.getSession();

		List<Request> requestListByStatus= ses
				.createQuery("from Request where reimbursementStatus = " + reimbursmentStatus, Request.class)
				.list();

		return requestListByStatus;
	}
}
