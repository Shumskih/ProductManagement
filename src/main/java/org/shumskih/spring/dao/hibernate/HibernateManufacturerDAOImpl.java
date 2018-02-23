package org.shumskih.spring.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shumskih.spring.dao.GenericDAO;
import org.shumskih.spring.model.Manufacturer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class HibernateManufacturerDAOImpl implements GenericDAO<Manufacturer> {
    private static final Logger logger = LoggerFactory.getLogger(HibernateManufacturerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Manufacturer manufacturer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(manufacturer);
        logger.info("Manufacturer successfully added. Manufacturer details: " + manufacturer);
    }

    public void update(Manufacturer manufacturer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(manufacturer);
        logger.info("Manufacturer successfully updated. Manufacturer detail: " + manufacturer);
    }

    public void remove(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer) session.load(Manufacturer.class, id);

        if(manufacturer != null) {
            session.delete(manufacturer);
        }

        logger.info("Manufacturer successfully remove. Author details: " + manufacturer);
    }

    public Manufacturer getById(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer) session.load(Manufacturer.class, id);
        logger.info("Manufacturer successfully loaded. Manufacturer details: " + manufacturer);

        return manufacturer;
    }

    @SuppressWarnings("unchecked")
    public List<Manufacturer> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Manufacturer> listOfManufacturers = session.createQuery("from Manufacturer").list();

        for(Manufacturer m : listOfManufacturers) {
            logger.info("List of Manufacturers: " + m);
        }
        return listOfManufacturers;
    }
}
