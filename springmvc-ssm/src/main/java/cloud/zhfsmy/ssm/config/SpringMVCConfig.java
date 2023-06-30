package cloud.zhfsmy.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//SpringMVC Servlet配置
@Configuration
@ComponentScan("cloud.zhfsmy.ssm.controller")
@EnableWebMvc
public class SpringMVCConfig {
}
