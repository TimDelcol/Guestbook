/*
 * The UserentityResource is a RESTful web service, implemented as a stateless
 * session bean, using an entity manager to create, delete and retrieve users.
 */
package beans;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import entities.Message;
import entities.Userentity;
import java.net.URI;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author BJORN
 */
@Path("beans")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class UserentityResource {
    
    @PersistenceContext(unitName = "Guestbook-ejbPU")
    private EntityManager em;
    
    @Context
    private UriInfo uriInfo;

    /**
     * Creating a new user
     */
    @POST
    public Response createNewUser(JAXBElement<Userentity> userJaxb){
        Userentity userEntity = userJaxb.getValue();
        em.persist(userEntity);
        
        URI userUri = uriInfo.getAbsolutePathBuilder().path(userEntity.getId().toString()).build();
        return Response.created(userUri).build();
    }
    
    
    /**
     * Getting a user by ID (URI)
     */
    @GET
    @Path("{id}/")
    public Userentity getUserById(@PathParam("id") Long id){
        Userentity user = em.find(Userentity.class, id);
        return user;
    }

    /**
     * Getting a user via session id
     */
    @GET
    public Userentity getUserViaSession(@CookieParam("sessionid") int id){
        Userentity user = em.find(Userentity.class, id);
        return user;
    }    
   
    /**
     * Finds all messages of a user.
     * @return Collection<Message>
     */
    @GET
    @Path("/messages/")
    public Collection<Message> getAllMessages(){
        Query query = em.createNamedQuery("findAllMyMessages");
        Collection<Message> messages = query.getResultList();
        return messages;
    }
}
