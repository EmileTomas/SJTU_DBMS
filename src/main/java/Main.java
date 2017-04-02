import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2017/4/2.
 */
public class Main {
    private static final SessionFactory factory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create session factory.");
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction tx=null;
        try {
            tx=session.getTransaction();

        } finally {
            session.close();
        }
    }


    public static Session getSession() throws HibernateException {
        return factory.openSession();
    }


}