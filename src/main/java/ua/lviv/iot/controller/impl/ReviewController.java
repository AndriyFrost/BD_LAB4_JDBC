package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractGenericController;
import ua.lviv.iot.model.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.dao.impl.ReviewDaoImpl;
import ua.lviv.iot.model.entity.Country;
import ua.lviv.iot.model.entity.Review;

import java.sql.SQLException;
import java.util.List;

public class ReviewController implements AbstractGenericController<Review> {


    ReviewDaoImpl dao = new ReviewDaoImpl();

    @Override
    public List<Review> findAll()  {
        return dao.findAll();
    }

    @Override
    public Review findOne(Integer id)  {
        return dao.findOne(id);
    }

    @Override
    public void create(Review entity)  {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Review entity)  {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);

    }
}
