package example;

import domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import viewresolvers.JsonViewResolver;
import viewresolvers.XmlViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * The application configuration for this Spring application
 *
 * @author mcrysler
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter
{
    /**
     * ${@inheritDoc}
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        // Configure the content negotiator
        configurer.ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }

    /*
     * Configure the content negotiating view resolver
     *
     * @param manager the content negotiation manager
     *
     * @return the view resolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager)
    {
        // Define the content negotiating view resolver
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();

        // Set the content negotiation manager
        resolver.setContentNegotiationManager(manager);

        // Define a list to hold view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        // Add to the list of view resolvers
        resolvers.add(xmlViewResolver());
        resolvers.add(jsonViewResolver());

        // Add the list to the content negotiating view resolver
        resolver.setViewResolvers(resolvers);

        // Return the content negotiating view resolver
        return resolver;
    }

    /*
     * Configure the view resolver that is responsible for returning XML
     *
     * @return an XML view resolver
     */
    @Bean
    public ViewResolver xmlViewResolver()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Person.class);
        return new XmlViewResolver(marshaller);
    }

    /*
     * Configure the view resolver that is responsible for returning JSON
     *
     * @return a JSON view resolver
     */
    @Bean
    public ViewResolver jsonViewResolver()
    {
        return new JsonViewResolver();
    }
}
