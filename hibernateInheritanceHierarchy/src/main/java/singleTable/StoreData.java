package singleTable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StoreData {


	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Employee employee = new Employee();
		employee.setName("some employee");
		
		Regular_Employee regularEmployee = new Regular_Employee();
		regularEmployee.setName("Olena");
		regularEmployee.setSalary(10000000);
		regularEmployee.setBonus(6000);
		
		Contract_Employee contractEmployee = new Contract_Employee();
		contractEmployee.setName("Contract Empl");
		contractEmployee.setPay_for_hour(500);
		contractEmployee.setContract_duration("15 hours");
		
		em.persist(employee);
		em.persist(regularEmployee);
		em.persist(contractEmployee);
		em.getTransaction().commit();
		
		List accounts = em.createQuery("select a from Employee a").getResultList();

		emf.close();
	}

}
