package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.ManDaoImpl;
import ua.lviv.iot.model.entity.Man;

import java.util.List;

public class ManController implements AbstractGenericController<Man> {

    ManDaoImpl dao = new ManDaoImpl();

    @Override
    public List<Man> findAll() {
        return dao.findAll();
    }

    @Override
    public Man findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Man entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Man entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
