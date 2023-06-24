import cloud.zhfsmy.annotation.config.SpringConfig;
import cloud.zhfsmy.annotation.controller.BookController;
import cloud.zhfsmy.annotation.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringJUnitConfig(SpringConfig.class)
public class IOCTest {
    @Autowired
    private DataSource dataSource;
    @Autowired

    private JdbcTemplate jdbcTemplate;
    @Autowired

    private BookController bookController;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println(jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class)));
    }

    @Test
    public void testMybatis() {
        bookController.getBookInfo(1);
    }
}
