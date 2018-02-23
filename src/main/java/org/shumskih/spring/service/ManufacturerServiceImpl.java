package org.shumskih.spring.service;

import org.shumskih.spring.dao.GenericDAO;
import org.shumskih.spring.dao.hibernate.HibernateManufacturerDAOImpl;
import org.shumskih.spring.model.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements GenericService<Manufacturer, UUID> {
    private GenericDAO<Manufacturer> manufacturerDAO;

    public void setManufacturerDAO(HibernateManufacturerDAOImpl manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    @Transactional
    public void add(Manufacturer manufacturer) {
        this.manufacturerDAO.add(manufacturer);
    }

    @Transactional
    public void update(Manufacturer manufacturer) {
        this.manufacturerDAO.update(manufacturer);
    }

    @Transactional
    public void remove(UUID id) {
        this.manufacturerDAO.remove(id);
    }

    @Transactional
    public Manufacturer getById(UUID id) {
        return this.manufacturerDAO.getById(id);
    }

    @Transactional
    public List<Manufacturer> getAll() {
        return this.manufacturerDAO.getAll();
    }
}
