package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.SessionDaoImpl;
import ua.lviv.iot.model.entity.Session;

import java.util.List;

public class SessionController implements AbstractGenericController<Session> {

    SessionDaoImpl dao = new SessionDaoImpl();

    @Override
    public List<Session> findAll() {
        return dao.findAll();
    }

    @Override
    public Session findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Session entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Session entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
