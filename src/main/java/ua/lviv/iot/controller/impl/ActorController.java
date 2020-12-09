package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.ActorDaoImpl;
import ua.lviv.iot.model.entity.Actor;

import java.util.List;

public class ActorController implements AbstractGenericController<Actor> {


    ActorDaoImpl dao = new ActorDaoImpl();

    @Override
    public List<Actor> findAll() {
        return dao.findAll();
    }

    @Override
    public Actor findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Actor entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Actor entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
