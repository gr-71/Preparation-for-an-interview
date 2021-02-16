package fifth.lesson.homework;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryGetter {

    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().addResource("hibernate.cfg.xml").configure();
        return configuration.buildSessionFactory();
    }
}
