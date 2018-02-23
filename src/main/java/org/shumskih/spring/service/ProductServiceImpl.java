package org.shumskih.spring.service;

import org.shumskih.spring.dao.GenericDAO;
import org.shumskih.spring.dao.hibernate.HibernateProductDAOImpl;
import org.shumskih.spring.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements GenericService<Product, UUID> {
    private GenericDAO<Product> productDAO;

    public void setProductDAO(HibernateProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public void add(Product product) {
        this.productDAO.add(product);
    }

    @Transactional
    public void update(Product product) {
        this.productDAO.update(product);
    }

    @Transactional
    public void remove(UUID id) {
        this.productDAO.remove(id);
    }

    @Transactional
    public Product getById(UUID id) {
        return this.productDAO.getById(id);
    }

    @Transactional
    public List<Product> getAll() {
        return this.productDAO.getAll();
    }
}
