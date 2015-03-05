package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The application entry point for this Spring application
 *
 * @author mcrysler
 */
@SpringBootApplication
public class Application
{
    /**
     * The main entry point for the application
     *
     * @param args the arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}