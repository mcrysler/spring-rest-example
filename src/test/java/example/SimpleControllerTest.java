package example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * A JUnit test for the simple controller
 *
 * @author mcrysler
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=8080", "management.port=0"})
public class SimpleControllerTest
{
    // Create a new test rest template
    private RestTemplate restTemplate = new TestRestTemplate();

    /**
     * Tests the /person API
     *
     * @throws Exception If an error occurs
     */
    @Test
    public void testPerson() throws Exception
    {
        // Make the call to the API
        String response = restTemplate.getForObject(
                "http://localhost:8080/person", String.class);
        assertNotNull(response);
        System.out.println(response);

        // Parse the JSON
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        assertNotNull(json);

        // Verify the first and last name
        assertEquals("Bin", json.get("firstName"));
        assertEquals("Wang", json.get("lastName"));

        // Get the array of hobbies
        JSONArray hobbies = (JSONArray) json.get("hobbies");
        assertNotNull(hobbies);
        assertEquals(2, hobbies.size());
        assertEquals("Being Awesome", hobbies.get(0));
        assertEquals("Big Data", hobbies.get(1));
    }
}