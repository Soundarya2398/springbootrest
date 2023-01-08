package com.te.employee1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.te.employee1.dto.Employee1;
@Repository
public class Emploee1DaoImplimentation implements Employee1Dao {
	@Override
	public Employee1 getEmployee(int empid) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Employee1 employee1 = null;

		try {
			factory = Persistence.createEntityManagerFactory("boot");
			manager = factory.createEntityManager();

			employee1 = manager.find(Employee1.class, empid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}
		if (employee1 != null) {
			return employee1;
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeDetail(int empid) {
		
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("boot");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = null;
			Employee1 employee = manager.find(Employee1.class, empid);

			if (employee != null) {
				try {
					transaction = manager.getTransaction();
					transaction.begin();
					manager.remove(employee);
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null)
						transaction.rollback();
				} finally {
					if (factory != null)
						factory.close();
					if (manager != null)
						manager.close();
				}
				return true;
			}
			return false;
		}

	@Override
	public List<Employee1> allEmployee() {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("boot");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	String detailsemp="From Employee1";
	Query query=manager.createQuery(detailsemp);
	
	List list=query.getResultList();
	transaction.commit();
	return list;
	
	
		
	}


}
