package example;

import domain.Person;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * A simple controller with a simple API definition
 */
@Controller
public class SimpleController
{
    /**
     * A simple API that returns a Person object in either JSON or XML format (default = JSON)
     *
     * @return a Person object in the requested format
     */
    @RequestMapping("/person")
    @ResponseBody
    public Person getPerson()
    {
        return new Person("Brennan", "Matthew");
    }
}