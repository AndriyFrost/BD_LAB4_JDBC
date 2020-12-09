package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Review;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl implements AbstractGenericDao<Review> {

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.review";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.review WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.review "
            + "(response, rating,recommended,man_id,film_id) VALUES ( ?, ?,?,?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.review"
            + " SET response=?, rating=?,recommended=?,man_id=?,film_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM andriy_moroz.review WHERE id=?";
    private static final String DELETE_WITH_MAN = "DELETE FROM andriy_moroz.review WHERE man_id=?";
    private static final String DELETE_WITH_FILM = "DELETE FROM andriy_moroz.review WHERE film_id=?";

    @Override
    public List<Review> findAll() {
        List<Review> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review company = new Review(
                        resultSet.getInt(1),
                        resultSet.getString("response"),
                        resultSet.getInt("rating"),
                        resultSet.getInt("recommended"),
                        resultSet.getInt("man_id"),
                        resultSet.getInt("film_id"));

                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Review findOne(Integer id) {
        Review company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Review(
                        resultSet.getInt(1),
                        resultSet.getString("response"),
                        resultSet.getInt("rating"),
                        resultSet.getInt("recommended"),
                        resultSet.getInt("man_id"),
                        resultSet.getInt("film_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Review company) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, company.getResponse());
            statement.setInt(2, company.getRating());
            statement.setInt(3, company.getRecommended());
            statement.setInt(4, company.getManId());
            statement.setInt(5, company.getFilmId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review review) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, review.getResponse());
            statement.setInt(2, review.getRating());
            statement.setInt(3, review.getRecommended());
            statement.setInt(4, review.getManId());
            statement.setInt(5, review.getFilmId());
            statement.setInt(6, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWithManId(Integer manId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_WITH_MAN)) {
            statement.setInt(1, manId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteWithFilmId(Integer filmId) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_WITH_FILM)) {
            statement.setInt(1, filmId);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
