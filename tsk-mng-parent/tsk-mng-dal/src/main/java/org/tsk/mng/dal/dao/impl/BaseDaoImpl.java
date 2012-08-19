package org.tsk.mng.dal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDaoImpl<DataType, PKType extends Serializable> {

	
	//TODO clear all unnecessary comments - Dvir To Anar
	
	//private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	final private Class<DataType> persistentClass;
	private Session session;

	public SessionFactory getSessionFactory() {
		//return sessionFactory;
		return hibernateTemplate.getSessionFactory();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<DataType>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];//TODO Dvir ask Anar - Should it used index 0 ?
	}

	public Class<DataType> getPersistentClass() {
		return persistentClass;
	}
 
    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

	public void save(DataType dt) {
//		Session session = getSession();
//		session.beginTransaction();
//		session.save(dt);
//		session.getTransaction().commit();
//		session.close();
		hibernateTemplate.saveOrUpdate(dt);
	}

	public DataType getByPK(PKType pk) {
//		Session session = getSession();
//		DataType dt = (DataType) session.get(getPersistentClass(), pk);
//		session.close();
		DataType dt = hibernateTemplate.get(getPersistentClass(), pk);
		return dt;
	}

	public void update(DataType dt) {
//		Session session = getSession();
//		session.beginTransaction();
//		session.update(dt);
//		session.getTransaction().commit();
//		session.close();
		hibernateTemplate.saveOrUpdate(dt);
	}

	public void delete(DataType dt) {
//		Session session = getSession();
//		session.beginTransaction();
//		session.delete(dt);
//		session.getTransaction().commit();
//		session.close();
		hibernateTemplate.delete(dt);
	}
	
	@SuppressWarnings("unchecked")
	public List<DataType> getList(){
		List<DataType> retList =(List<DataType>)hibernateTemplate.find("from " + getPersistentClass().getName()); 

		return retList;
	}
}
