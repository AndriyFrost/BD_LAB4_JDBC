package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.FilmHasActorDaoImpl;
import ua.lviv.iot.model.entity.FilmHasActor;

import java.util.List;

public class FilmHasActorController {


    FilmHasActorDaoImpl dao = new FilmHasActorDaoImpl();

    public List<FilmHasActor> findAll() {
        return dao.findAll();
    }


    public FilmHasActor findOne(Integer id) {
        return dao.findOne(id);
    }

    public void create(FilmHasActor entity) {
        dao.create(entity);
    }

    public void update() {
        dao.update();
    }

    public void delete(Integer actorId) {
        dao.deleteWithActor(actorId);
    }
}
