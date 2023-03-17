package jpastudy.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");

		EntityManager em = emf.createEntityManager();

		EntityTransaction ts = em.getTransaction();
		ts.begin();

		/* code */
		try {
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
