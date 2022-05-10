package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Manager;
import com.revature.util.HibernateUtil;

public class ManagerDAO {
	
	public void insertWithoutCasting(Manager manager) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(manager);
		tx.commit();
	}
	
	public int insert(Manager manager) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		int pk = (int)ses.save(manager);
		tx.commit();
		return pk;
	}
	
	public List<Manager> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Manager> managerList= ses.createQuery("from Manager", Manager.class).list();
		return managerList;
	}
	
	public Manager selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Manager manager = ses.get(Manager.class, id);
		return manager;
	}
	
	public void update(Manager manager) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(manager);
		tx.commit();
	}
	
	public void delete(Manager manager) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(manager);
		tx.commit();
	}

}
