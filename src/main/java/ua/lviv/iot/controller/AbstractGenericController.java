package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractGenericController<Entity> {

//    AbstractGenericDaoImpl<Entity> getDao();

    List<Entity> findAll() throws SQLException;

    Entity findOne(Integer id) throws SQLException;

    void create(Entity entity) throws SQLException;

    void update(Integer id, Entity entity) throws SQLException;

    void delete(Integer id) throws SQLException;

}
