package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Actor;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActorDaoImpl implements AbstractGenericDao<Actor> {



    FilmHasActorDaoImpl filmHasActorDao = new FilmHasActorDaoImpl();

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.actor";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.actor WHERE manId=?";
    private static final String CREATE = "INSERT andriy_moroz.actor "
            + "(acting_education, biography,manId) VALUES ( ?, ?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.actor"
            + " SET acting_education=?, biography=?  WHERE manId=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.actor WHERE manId=?";
    private static final String DELETE_WITH_CINEMA = "DELETE FROM andriy_moroz.hall WHERE cinema_id=?";

    @Override
    public List<Actor> findAll() {
        List<Actor> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Actor company = new Actor(
                        resultSet.getInt("acting_education"),
                        resultSet.getString("biography"),
                        resultSet.getInt("manId"));
                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Actor findOne(Integer id)  {
        Actor company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(3, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Actor(
                        resultSet.getInt("acting_education"),
                        resultSet.getString("biography"),
                        resultSet.getInt("manId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Actor actor) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, actor.getActingEducation());
            statement.setString(2, actor.getBiography());
            statement.setInt(3, actor.getManId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Actor actor) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, actor.getActingEducation());
            statement.setString(1, actor.getBiography());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            filmHasActorDao.deleteWithActor(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
