package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.dao.AbstractGenericDao;
import ua.lviv.iot.model.entity.Cinema;
import ua.lviv.iot.model.entity.Film;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmDaoImpl implements AbstractGenericDao<Film> {

    SessionDaoImpl sessionDao = new SessionDaoImpl();
    FilmHasActorDaoImpl filmHasActorDao = new FilmHasActorDaoImpl();
    ReviewDaoImpl reviewDao = new ReviewDaoImpl();

    private static final String GET_ALL = "SELECT * FROM andriy_moroz.film";
    private static final String GET_ONE = "SELECT * FROM andriy_moroz.film WHERE id=?";
    private static final String CREATE = "INSERT andriy_moroz.film "
            + "(genre, move_title,description,release_date) VALUES ( ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE andriy_moroz.film"
            + " SET genre=?, move_title=?,description=?,release_date=?  WHERE id=?";

    private static final String DELETE = "DELETE FROM andriy_moroz.film WHERE id=?";

    @Override
    public List<Film> findAll() {
        List<Film> companies = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film country = new Film(
                        resultSet.getInt(1),
                        resultSet.getString("genre"),
                        resultSet.getString("move_title"),
                        resultSet.getString("description"),
                        resultSet.getString("release_date"));

                companies.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Film findOne(Integer id) {
        Film company = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Film(
                        resultSet.getInt(1),
                        resultSet.getString("genre"),
                        resultSet.getString("move_title"),
                        resultSet.getString("description"),
                        resultSet.getString("release_date"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Film film) {

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, film.getGenre());
            statement.setString(2, film.getMoveTitle());
            statement.setString(3, film.getGenre());
            statement.setString(4, film.getDescription());
            statement.setString(5, film.getReleaseDate());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Film film) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, film.getGenre());
            statement.setString(2, film.getMoveTitle());
            statement.setString(3, film.getGenre());
            statement.setString(4, film.getDescription());
            statement.setString(5, film.getReleaseDate());
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            filmHasActorDao.deleteWithFilm(id);
            sessionDao.deleteWithFilm(id);
            reviewDao.deleteWithFilmId(id);
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
