package cloud.zhfsmy.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//定义为Spring配置类
@Configuration
//开启Bean扫描
@ComponentScan("cloud.zhfsmy.ssm.service")
//加载配置文件
@PropertySource("classpath:jdbc.properties")
//开启Spring事务管理
@EnableTransactionManagement
//引入JDBC,MyBatis配置文件
@Import({JdbcConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
