package viewresolvers;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

/**
 * The JSON view resolver
 *
 * @author mcrysler
 */
public class JsonViewResolver implements ViewResolver
{
    /**
     * Returns the view in JSON format
     *
     * @param viewName the name of the view
     * @param locale the locale
     *
     * @return the JSON view
     *
     * @throws Exception If an error occurs
     */
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception
    {
        // Define the view
        MappingJackson2JsonView view = new MappingJackson2JsonView();

        // Set the properties
        view.setPrettyPrint(true);

        // Return the view
        return view;
    }
}
