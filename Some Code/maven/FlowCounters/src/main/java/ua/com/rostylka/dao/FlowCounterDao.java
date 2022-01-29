package ua.com.rostylka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ua.com.rostylka.models.FlowCounter;

import java.util.LinkedList;
import java.util.List;

@Component
public class FlowCounterDao {

    private List <FlowCounter> flowCounters = new LinkedList<>();

    private static FlowCounterDao flowCounterDaoInstance = null;
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sf;

    static {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(FlowCounter.class);
        builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        sf = configuration.buildSessionFactory();
    }

    private FlowCounterDao() {

    }

    public void create(FlowCounter flowCounter) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(flowCounter);
        transaction.commit();
        session.close();

    }

    public FlowCounter readByID(int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        FlowCounter flowCounter = (FlowCounter) session.get(FlowCounter.class, id);
        transaction.commit();
        session.close();
        return flowCounter;
    }

    public void update(FlowCounter counter) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(counter);
        transaction.commit();
        session.close();

    }

    public void delete(FlowCounter flowCounter) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flowCounter);
        transaction.commit();
        session.close();

    }

    public List<FlowCounter> readAll() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        flowCounters = session.createQuery("from FlowCounter").list();
        transaction.commit();
        session.close();
        return flowCounters;
    }

}
