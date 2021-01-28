package com.tyss.demo.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;


import com.tyss.demo.dto.Employee;

@Repository

public class EmployeeDaoImple implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory emf=null;
	
	@Transactional
	public List<Employee> listOfEmployee() {
		List<Employee>list =new ArrayList<Employee>();
		EntityManager em = emf.createEntityManager();
		EntityTransaction transcation = em.getTransaction();
		transcation.begin();
		TypedQuery<Employee> typedQuery= em.createQuery("FROM Employee ", Employee.class);
		list=typedQuery.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

	public boolean addUser(String name, String address) {
		Employee emp=new Employee();
		EntityManager em = emf.createEntityManager();
		EntityTransaction transcation = em.getTransaction();
		transcation.begin();
		emp.setName(name);
		emp.setAddress(address);
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public Employee fetchUserById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transcation = em.getTransaction();
		transcation.begin();
		Employee emp=em.find(Employee.class, id);
		em.getTransaction().commit();
		em.close();
		return emp;
	}

	public boolean updateUser(Employee employee) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transcation = em.getTransaction();
		transcation.begin();
		Employee emp=em.merge(employee);
		em.getTransaction().commit();
		em.close();
		System.out.println(emp);
		return true;
	}

	public boolean deleteUserbyId(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transcation = em.getTransaction();
		transcation.begin();
		Employee emp=em.getReference(Employee.class, id);
		em.remove(emp);
		em.getTransaction().commit();
		em.close();
		return true;
	}

}
