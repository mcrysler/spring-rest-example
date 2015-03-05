package viewresolvers;

import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Locale;

/**
 * The XML view resolver
 *
 * @author mcrysler
 */
public class XmlViewResolver implements ViewResolver
{
    // Define the marshaller
    private Marshaller marshaller;

    /**
     * Sets the marshaller for the view resolver
     *
     * @param marshaller the marshaller
     */
    public XmlViewResolver(Marshaller marshaller)
    {
        this.marshaller = marshaller;
    }

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
        MarshallingView view = new MarshallingView();

        // Set the marshaller
        view.setMarshaller(marshaller);

        // Return the view
        return view;
    }
}
