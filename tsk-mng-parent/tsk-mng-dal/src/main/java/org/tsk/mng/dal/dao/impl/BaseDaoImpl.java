package org.tsk.mng.dal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<DataType, PKType extends Serializable> {

	private SessionFactory sessionFactory;
	final private Class<DataType> persistentClass;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<DataType>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<DataType> getPersistentClass() {
		return persistentClass;
	}

    public void setSession(Session session) {
        this.session = session;
    }
 
    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(DataType dt) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(dt);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public DataType getByPK(PKType pk) {
		Session session = sessionFactory.openSession();
		DataType dt = (DataType) session.get(getPersistentClass(), pk);
		session.close();
		return dt;
	}

	public void update(DataType dt) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(dt);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(DataType dt) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(dt);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<DataType> getList(){
		return null;
	}
}
