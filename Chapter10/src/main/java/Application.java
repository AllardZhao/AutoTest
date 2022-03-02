import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication      // 将其托管给SpringBoot
@ComponentScan("com.course")   // 需要扫描的包
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
