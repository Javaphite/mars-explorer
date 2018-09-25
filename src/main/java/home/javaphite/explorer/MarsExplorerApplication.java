package home.javaphite.explorer;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
 import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "home.javaphite.explorer")
public class MarsExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsExplorerApplication.class, args);
    }
}
