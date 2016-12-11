package test_Hibernate;

import jdbc.modules.Skills;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateTestConnection {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HibernateTestConnection.class);

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Skills.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Object t = session.createNativeQuery("SELECT 1 FROM SKILLS").list();
            System.out.println("Session = " + t.toString());

        }

    }
}
