package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.entity.Country;

import java.util.List;

public class CountryController implements AbstractGenericController<Country> {

    CountryDaoImpl dao = new CountryDaoImpl();

    @Override
    public List<Country> findAll() {
        return dao.findAll();
    }

    @Override
    public Country findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Country entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Country entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
