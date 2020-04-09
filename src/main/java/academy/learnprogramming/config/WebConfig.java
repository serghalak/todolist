package academy.learnprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="academy.learnprogramming")
public class WebConfig {

    public static final String RESOLVER_PREFIX="/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX=".jsp";

    @Bean
    public ViewResolver viewResolver(){
        UrlBasedViewResolver resolver=
                new InternalResourceViewResolver();
        resolver.setPrefix(RESOLVER_PREFIX);
        resolver.setSuffix(RESOLVER_SUFFIX);
        return resolver;
    }
}
