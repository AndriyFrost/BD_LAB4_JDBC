package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Cinema;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaDaoImpl implements AbstractGenericDao<Cinema> {

    HallDaoImpl hallDao = new HallDaoImpl();
    private static final String GET_ALL = "SELECT * FROM andriy_moroz.cinema";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.cinema WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.cinema "
            + "(city, address,country_id) VALUES ( ?, ?, ?)";
    private static final String UPDATE = "UPDATE andriy_moroz.cinema"
            + " SET city=?, address=?,country_id=?  WHERE id=?";

    private static final String DELETE = "DELETE FROM andriy_moroz.cinema WHERE id=?";
    private static final String DELETE_CINEMA = "DELETE FROM andriy_moroz.cinema WHERE country_id=?";


    @Override
    public List<Cinema> findAll() {
        List<Cinema> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cinema country = new Cinema(
                        resultSet.getInt(1),
                        resultSet.getString("city"),
                        resultSet.getString("address"),
                        resultSet.getInt("country_id"));

                companies.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Cinema findOne(Integer id) {
        Cinema company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Cinema(
                        resultSet.getInt(1),
                        resultSet.getString("city"),
                        resultSet.getString("address"),
                        resultSet.getInt("country_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Cinema cinema) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, cinema.getCity());
            statement.setString(2, cinema.getAddress());
            statement.setInt(3, cinema.getCountryId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Cinema cinema) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, cinema.getCity());
            statement.setString(2, cinema.getAddress());
            statement.setInt(3, cinema.getCountryId());
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
            hallDao.deleteWithCinema(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCinemaWithCountry(Integer countryId) {
        List<Cinema> all = findAll();
        List<Cinema> cinemaForCountryId = all.stream()
                .filter(cinema -> cinema.getCountryId().equals(countryId))
                .collect(Collectors.toList());

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_CINEMA)) {
            cinemaForCountryId.forEach(cinema -> hallDao.deleteWithCinema(cinema.getId()));
            statement.setInt(1, countryId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
