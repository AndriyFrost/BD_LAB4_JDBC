package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Session;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SessionDaoImpl implements AbstractGenericDao<Session> {



    private static final String GET_ALL = "SELECT * FROM andriy_moroz.session";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.session WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.session "
            + "(event_time, ticket_price,ticket_sold,film_id,actor_id) VALUES ( ?, ?, ?,?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.session"
            + " SET event_time=?, ticket_price=?,ticket_sold=?,film_id=?,actor_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.session WHERE id=?";
    private static final String DELETE_SESSION_WITH_HALL = "DELETE FROM andriy_moroz.session WHERE hall_id=?";
    private static final String DELETE_SESSION_WITH_FILM = "DELETE FROM andriy_moroz.session WHERE film_id=?";


    @Override
    public List<Session> findAll()  {
        List<Session> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Session country = new Session(
                        resultSet.getInt(1),
                        resultSet.getString("event_time"),
                        resultSet.getInt("ticket_price"),
                        resultSet.getInt("ticket_sold"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("actor_id"));

                companies.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Session findOne(Integer id){
        Session company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Session(
                        resultSet.getInt(1),
                        resultSet.getString("event_time"),
                        resultSet.getInt("ticket_price"),
                        resultSet.getInt("ticket_sold"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("actor_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Session company) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, company.getEventTime());
            statement.setInt(2, company.getTicketPrice());
            statement.setInt(3, company.getTicketSold());
            statement.setInt(4, company.getFilmId());
            statement.setInt(5, company.getHallId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Session session)  {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, session.getEventTime());
            statement.setInt(2, session.getTicketPrice());
            statement.setInt(3, session.getTicketSold());
            statement.setInt(4, session.getFilmId());
            statement.setInt(5, session.getHallId());
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id)  {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithHall(Integer hallId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_SESSION_WITH_HALL)) {
            statement.setInt(1, hallId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteWithFilm(Integer filmId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_SESSION_WITH_FILM)) {
            statement.setInt(1, filmId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
