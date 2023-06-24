package cloud.zhfsmy.annotation.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//全注解配置
@Configuration
//开启bean扫描
@ComponentScan("cloud.zhfsmy.annotation")
//加载配置文件
@PropertySource("classpath:jdbc.properties")
//导入自定义配置
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
