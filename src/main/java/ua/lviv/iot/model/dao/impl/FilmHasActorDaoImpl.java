package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.FilmHasActor;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmHasActorDaoImpl {


    SessionDaoImpl sessionDao = new SessionDaoImpl();

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.film_has_actor";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.film_has_actor WHERE manId=?";
    private static final String CREATE = "INSERT andriy_moroz.actor "
            + "(film_id, actor_id) VALUES ( ?, ?)";
    private static final String DELETE = "DELETE FROM andriy_moroz.film_has_actor WHERE manId=?";
    private static final String DELETE_WITH_ACTOR = "DELETE FROM andriy_moroz.film_has_actor WHERE actor_id=?";
    private static final String DELETE_WITH_FILM = "DELETE FROM andriy_moroz.film_has_actor WHERE film_id=?";

    public List<FilmHasActor> findAll() {
        List<FilmHasActor> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FilmHasActor company = new FilmHasActor(
                        resultSet.getInt("film_id"),
                        resultSet.getInt("actor_id"));
                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    public FilmHasActor findOne(Integer id) {
        FilmHasActor company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(3, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new FilmHasActor(
                        resultSet.getInt("film_id"),
                        resultSet.getInt("actor_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    public void create(FilmHasActor filmHasActor) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, filmHasActor.getActorId());
            statement.setInt(2, filmHasActor.getFilmId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void update() {
        System.out.println("You can`t update many to many, please delete this film-actor and create new");
    }

//    public void delete(Integer actorId, Integer filmId) {
//        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
//            statement.setInt(1, id);
//            System.out.println(statement);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void deleteWithActor(Integer actorId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_WITH_ACTOR)) {
            statement.setInt(1, actorId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithFilm(Integer filmId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_WITH_FILM)) {
            statement.setInt(1, filmId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
