package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.CinemaDaoImpl;
import ua.lviv.iot.model.entity.Cinema;

import java.util.List;

public class CinemaController implements AbstractGenericController<Cinema> {

    CinemaDaoImpl dao = new CinemaDaoImpl();

    @Override
    public List<Cinema> findAll() {
        return dao.findAll();
    }

    @Override
    public Cinema findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Cinema entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Cinema entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
