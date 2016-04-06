package org.hiberate.dao;

import javax.transaction.Transaction;
import javax.websocket.SessionException;

import org.apache.catalina.User;
import org.hiberate.entity.HiberateUtil;
import org.hibernate.Session;


public class UserDao {
	public static void Save(org.hiberate.entity.User user) throws SessionException {
		Session session = HiberateUtil.getSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static User findById(int id) throws SessionException{
		Session session=HiberateUtil.getSession();
		
		User user=null;
		session.beginTransaction();
		try {
			user=(User) session.get(org.hiberate.entity.User.class, id);
			session.getTransaction().commit();
		} catch(Exception e) {
			// TODO: handle finally clause
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return user;
	}
	public static void update(org.hiberate.entity.User user) throws SessionException {
		Session session=HiberateUtil.getSession();
		session.beginTransaction();
		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	public static void delete(org.hiberate.entity.User user) throws SessionException {
		Session session=HiberateUtil.getSession();
		try {
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
}
