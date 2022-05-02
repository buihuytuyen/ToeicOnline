package vn.myclass.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory SessionFactory = buildSessionFatory();
    private static SessionFactory buildSessionFatory() {
        try {
            // create sessionfactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e){
            System.out.println("Initial session factory fail");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return SessionFactory;
    }
}
