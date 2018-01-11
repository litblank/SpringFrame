package core.test.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunMain {

	public static void main(String[] args) {
		SessionFactory sf =null;
		Session session =null;
		try {
			Configuration cfg = new Configuration().configure();
			/*ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();*/
			sf = cfg.buildSessionFactory();//serviceRegistry
			session = sf.openSession();
			Transaction tx = session.beginTransaction();

			AdminUser user = new AdminUser();
			user.setId(1);
			user.setName("cyds士大夫");
			user.setCreateTime(new Date());
			session.save(user);

			tx.commit();
			session.close();
			sf.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
