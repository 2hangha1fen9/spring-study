package cloud.zhfsmy.jdbc.dao.impl;

import cloud.zhfsmy.jdbc.dao.UserDAO;
import cloud.zhfsmy.jdbc.entity.User;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean updateBalance(Integer userId, Integer balance) {
        String sql = "update user set balance = balance - ? where id = ?";
        int rows = jdbcTemplate.update(sql, balance, userId);
        return rows > 0;
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
    }
}
