package seventh.lesson.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:seventh.properties")
@ComponentScan("seventh.lesson.homework")
public class StudentConfig implements WebMvcConfigurer {
}
