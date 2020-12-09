package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.FilmDaoImpl;
import ua.lviv.iot.model.entity.Film;

import java.util.List;

public class FilmController implements AbstractGenericController<Film> {

    FilmDaoImpl dao = new FilmDaoImpl();

    @Override
    public List<Film> findAll() {
        return dao.findAll();
    }

    @Override
    public Film findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(Film entity) {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Film entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
