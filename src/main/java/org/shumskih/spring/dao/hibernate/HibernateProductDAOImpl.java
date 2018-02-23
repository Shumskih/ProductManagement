package org.shumskih.spring.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shumskih.spring.dao.GenericDAO;
import org.shumskih.spring.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class HibernateProductDAOImpl implements GenericDAO<Product> {
    private static final Logger logger = LoggerFactory.getLogger(HibernateProductDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Product successfully added. Product details: " + product);
    }

    public void update(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product successfully updated. Product detail: " + product);
    }

    public void remove(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);

        if(product != null) {
            session.delete(product);
        }

        logger.info("Product successfully remove. Product details: " + product);
    }

    public Product getById(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        logger.info("Product successfully loaded. Product details: " + product);

        return product;
    }

    public Product getByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.createQuery("from Product where name = :name").list();
        logger.info("Product successfully loaded. Product details: " + product);

        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> listOfProducts = session.createQuery("from Product").list();

        for(Product p : listOfProducts) {
            logger.info("List of Products: " + p);
        }
        return listOfProducts;
    }
}