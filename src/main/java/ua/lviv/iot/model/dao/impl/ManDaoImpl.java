package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Man;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManDaoImpl implements AbstractGenericDao<Man> {
    ActorDaoImpl actorDao = new ActorDaoImpl();
    ReviewDaoImpl reviewDao = new ReviewDaoImpl();
    private static final String GET_ALL = "SELECT * FROM andriy_moroz.man";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.man WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.man "
            + "(first_name, last_name,age,gender) VALUES ( ?, ?,?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.man"
            + " SET first_name=?, last_name=?,age=?,gender=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.man WHERE id=?";
    private static final String DELETE_WITH_CINEMA = "DELETE FROM andriy_moroz.hall WHERE cinema_id=?";

    @Override
    public List<Man> findAll() {
        List<Man> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Man company = new Man(
                        resultSet.getInt(1),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"));

                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Man findOne(Integer id)  {
        Man company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Man(
                        resultSet.getInt(1),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Man man) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, man.getFirstName());
            statement.setString(2, man.getFirstName());
            statement.setInt(3, man.getAge());
            statement.setString(4, man.getGender());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Man man) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, man.getFirstName());
            statement.setString(2, man.getFirstName());
            statement.setInt(3, man.getAge());
            statement.setString(4, man.getGender());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            actorDao.delete(id);
            reviewDao.deleteWithManId(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
