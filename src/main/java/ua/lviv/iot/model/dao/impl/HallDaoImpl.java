package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Hall;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HallDaoImpl implements AbstractGenericDao<Hall> {

    SessionDaoImpl sessionDao = new SessionDaoImpl();

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.hall";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.hall WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.hall "
            + "(numberOfSeats, cinemaId) VALUES ( ?, ?)";
    private static final String UPDATE = "UPDATE andriy_moroz.hall"
            + " SET numberOfSeats=?, cinemaId=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.hall WHERE id=?";
    private static final String DELETE_WITH_CINEMA = "DELETE FROM andriy_moroz.hall WHERE cinema_id=?";

    @Override
    public List<Hall> findAll() {
        List<Hall> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Hall company = new Hall(
                        resultSet.getInt(1),
                        resultSet.getInt("number_of_seats"),
                        resultSet.getInt("cinema_id"));

                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Hall findOne(Integer id) {
        Hall company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Hall(
                        resultSet.getInt(1),
                        resultSet.getInt("number_of_seats"),
                        resultSet.getInt("cinema_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Hall company) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, company.getCinemaId());
            statement.setInt(2, company.getNumberOfSeats());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Hall company) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(2, company.getCinemaId());
            statement.setInt(1, company.getNumberOfSeats());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithCinema(Integer cinemaId) {
        List<Hall> all = findAll();
        List<Hall> hallWithCinemaId = all.stream()
                .filter(hall -> hall.getCinemaId().equals(cinemaId))
                .collect(Collectors.toList());

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_WITH_CINEMA)) {
            hallWithCinemaId.forEach(hall -> sessionDao.deleteWithHall(hall.getId()));

            statement.setInt(1, cinemaId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            sessionDao.deleteWithHall(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



