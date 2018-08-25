package home.javaphite.explorer;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "home.javaphite.explorer")
public class MarsExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsExplorerApplication.class, args);
    }
}
