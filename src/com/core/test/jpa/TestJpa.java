package core.test.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		String persistenceUnitName="JpaFrame";
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		Customer cs=new Customer();
		cs.setId(1);
		cs.setLastName("都收费");
		cs.setEmail("6272@qq.com");
		cs.setAge(12);
		cs.setCreatetime(new Date());
		
		entityManager.persist(cs);
		
		entityTransaction.commit();
		
		entityManagerFactory.close();
	}

}
