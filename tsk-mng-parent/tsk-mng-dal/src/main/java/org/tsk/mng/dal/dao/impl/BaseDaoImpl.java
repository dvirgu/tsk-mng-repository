package org.tsk.mng.dal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDaoImpl<DataType, PKType extends Serializable> {

	
	//TODO clear all unnecessary comments - Dvir To Anar
	//TODO should add throwing of exceptions 
	
	//private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	final private Class<DataType> persistentClass;
	private Session session;

	public SessionFactory getSessionFactory() {
		//return sessionFactory;
		return hibernateTemplate.getSessionFactory();
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
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

	public boolean save(DataType dt, PKType pk) {
		if (dt != null) {
			hibernateTemplate.saveOrUpdate(dt);
			DataType verifyUser = getByPK(pk);

			return verifyUser != null;
		}

		throw new NullPointerException(getPersistentClass().getSimpleName() + " is null");
	}

	public DataType getByPK(PKType pk) {
		DataType dt = hibernateTemplate.get(getPersistentClass(), pk);
		return dt;
	}

	public void update(DataType dt) {
		hibernateTemplate.saveOrUpdate(dt);
	}

	public boolean delete(DataType dt ,PKType pk) {
		if (dt == null) {
			throw new NullPointerException(getPersistentClass().getSimpleName() + " is null");
		}

		hibernateTemplate.delete(dt); // invoke Base delete
		DataType verifyDelete = getByPK(pk);

		return verifyDelete == null; // equal to null , means user does not
		// exist any more
	}
	
	@SuppressWarnings("unchecked")
	public List<DataType> getList(){
		List<DataType> retList =(List<DataType>)hibernateTemplate.find("from " + getPersistentClass().getSimpleName()); 

		return retList;
	}
}
