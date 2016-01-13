package domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcrysler on 3/3/15.
 */
@XmlRootElement(name = "person")
public class Person
{
    // Define private class variables
    private String firstName;
    private String lastName;
    private List<String> hobbies = new ArrayList<String>();

    /**
     * Default constructor - needed by JAXB implementation
     */
    public Person() { }

    /**
     * Constructor to populate private variables
     *
     * @param firstName the first name
     * @param lastName the last name
     */
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies.add("Being Awesome");
        this.hobbies.add("Big Data");
    }

    /**
     * Sets the first name
     *
     * @param firstName the first name
     */
    @XmlElement
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Returns the first name
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Sets the last name
     *
     * @param lastName the last name
     */
    @XmlElement
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Returns the last name
     *
     * @return the last name
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Sets the list of hobbies
     *
     * @param hobbies the list of hobbies
     */
    @XmlElement
    public void setHobbies(List<String> hobbies)
    {
        this.hobbies = hobbies;
    }

    /**
     * Returns the list of hobbies
     *
     * @return the list of hobbies
     */
    public List<String> getHobbies()
    {
        return this.hobbies;
    }
}
