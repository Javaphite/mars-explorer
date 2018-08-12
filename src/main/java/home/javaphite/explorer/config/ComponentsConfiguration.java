package home.javaphite.explorer.config;

import home.javaphite.explorer.model.Area;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "home.javaphite.explorer")
public class ComponentsConfiguration {
    @Bean
    public Area area() {
        return new Area(3,3);
    }
}
