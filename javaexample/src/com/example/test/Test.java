package com.example.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.pojo.Employee;

/**
 * @author olena.viliuzhanina
 *
 */
public class Test {

	private static final String PERSISTENCE_UNIT_NAME = "employee";
	private static EntityManagerFactory factory;
	
	public static void main(String...args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e");
		List<Employee> employeeList = q.getResultList();
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
		System.out.println("Size: " + employeeList.size());
		
		em.getTransaction().begin();
		Employee emp = new Employee();
		emp.setName("Olena");
		emp.setEmail("olena@gmail.com");
		emp.setDepartment("IT");
		
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}
}

