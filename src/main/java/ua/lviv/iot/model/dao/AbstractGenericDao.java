package ua.lviv.iot.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractGenericDao<Entity> {

    List<Entity> findAll() throws SQLException;

    Entity findOne(Integer id) throws SQLException;

    void create(Entity object) throws SQLException;

    void update(Integer id, Entity object) throws SQLException;

    void delete(Integer id) throws SQLException;
}
