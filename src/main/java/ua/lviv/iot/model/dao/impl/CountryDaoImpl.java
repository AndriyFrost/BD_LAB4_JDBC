package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Country;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements AbstractGenericDao<Country> {

    CinemaDaoImpl cinemaDao = new CinemaDaoImpl();

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.country";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.country WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.country "
            + "(capital, population,area_in_sk,country_name) VALUES ( ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.country"
            + " SET capital=?, population=?,area_in_sk=?,country_name=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.country WHERE id=?";

    @Override
    public List<Country> findAll(){
        List<Country> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(
                        resultSet.getInt(1),
                        resultSet.getString("capital"),
                        resultSet.getInt("population"),
                        resultSet.getDouble("area_in_sk"),
                        resultSet.getString("country_name"));

                companies.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Country findOne(Integer id)  {
        Country company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Country(
                        resultSet.getInt(1),
                        resultSet.getString("capital"),
                        resultSet.getInt("population"),
                        resultSet.getDouble("area_in_sk"),
                        resultSet.getString("country_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Country company){

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, company.getCapital());
            statement.setInt(2, company.getPopulation());
            statement.setDouble(3, company.getAreaInSk());
            statement.setString(4, company.getCountryName());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Country company)  {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, company.getCapital());
            statement.setInt(2, company.getPopulation());
            statement.setDouble(3, company.getAreaInSk());
            statement.setString(4, company.getCountryName());
            statement.setInt(5, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id)  {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            cinemaDao.deleteCinemaWithCountry(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
