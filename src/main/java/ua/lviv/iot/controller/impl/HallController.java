package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.HallDaoImpl;
import ua.lviv.iot.model.entity.Hall;

import java.util.List;

public class HallController implements AbstractGenericController<Hall> {

    HallDaoImpl dao = new HallDaoImpl();

    @Override
    public List<Hall> findAll() {
        return dao.findAll();
    }

    @Override
    public Hall findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Hall entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Hall entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }

}
