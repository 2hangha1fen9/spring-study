package cloud.zhfsmy.jdbc.dao.impl;

import cloud.zhfsmy.jdbc.dao.BookDAO;
import cloud.zhfsmy.jdbc.entity.Book;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from book where id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
    }

    @Override
    public boolean updateStock(Integer bookId, Integer count) {
        String sql = "update book set stock = stock - ? where id = ?";
        int rows = jdbcTemplate.update(sql, count, bookId);
        return rows > 0;
    }

    @Override
    public Book getBookById(Integer bookId) {
        String sql = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), bookId);
    }
}
