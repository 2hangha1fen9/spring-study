import cloud.zhfsmy.jdbc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTest {
    @Autowired
    JdbcTemplate jdbc;

    //添加
    @Test
    public void add() {
        String sql = "insert into user values(null,?,?,?)";
        int rows = jdbc.update(sql, "王五", 21, "男");
        System.out.println(rows);
    }

    //删除
    @Test
    public void delete() {
        String sql = "delete from user where id = ?";
        int rows = jdbc.update(sql, 1);
        System.out.println(rows);
    }

    //修改
    @Test
    public void update() {
        String sql = "update user set age = ? where name = ?";
        int rows = jdbc.update(sql, 30, "张三");
        System.out.println(rows);
    }

    //查询
    @Test
    public void selectList() {
        String sql = "select * from user";
        List<User> list = jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }

    //查询单个对象
    @Test
    public void selectForObject() {
        String sql = "select * from user where name = ?";
        int userCount = jdbc.queryForObject("select count(id) from user", Integer.class);
        User user1 = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), "张三");
        User user2 = jdbc.queryForObject(sql, (row, index) -> {
            User user = new User();
            user.setId(row.getInt("id"));
            user.setName(row.getString("name"));
            user.setAge(row.getInt("age"));
            user.setSex(row.getString("sex"));
            return user;
        }, "李四");
        System.out.println(userCount);
        System.out.println(user1);
        System.out.println(user2);
    }
}
