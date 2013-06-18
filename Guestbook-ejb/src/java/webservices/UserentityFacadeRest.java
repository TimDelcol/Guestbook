package webservices;

import beans.AbstractFacade;
import entities.Userentity;
import interceptors.LoggingInterceptor;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author matthias
 */
@Path("rest")
@Stateless
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
@Interceptors(LoggingInterceptor.class)
public class UserentityFacadeRest extends AbstractFacade<Userentity>{

	@PersistenceContext(unitName = "Guestbook-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserentityFacadeRest() {
		super(Userentity.class);
	}
        
        
        @PUT
        @Consumes({"application/xml", "application/json"})
        @Override
        public void create(Userentity user) {
            super.create(user);
        }
        
        @POST
        @Consumes({"application/xml", "application/json"})
        @Override
        public void edit(Userentity user) {
            super.edit(user);
        }
        
        @DELETE
        @Path("{user}")
        @Override
        public void remove(@PathParam("user") Userentity user) {
            super.remove(user);
        }
        

        @GET
        @Path("{id}")
        @Produces({"application/xml", "application/json"})
        Userentity find(@PathParam("id") Integer id) {
            Query query = em.createNamedQuery("Userentity.findById")
                    .setParameter("id", id);
            Userentity user = (Userentity) query.getSingleResult();
            return user;
        }
        
        @GET
        @Produces({"application/xml", "application/json"})
        @Override
        public List<Userentity> findAll() {
            Query query = em.createNamedQuery("Userentity.findAll");
            List<Userentity> users = query.getResultList();
            return users;
        }
        
        @GET
        @Path("{from}/{to}")
        @Produces({"application/xml", "application/json"})
        List<Userentity> findRange(@PathParam("from") Integer from,
        @PathParam("to") Integer to) {
            return super.findRange(new int[]{from, to});
        }

        @GET
        @Path("count")
        @Produces("text/plain")
        public String countREST() {
            return String.valueOf(super.count());
        }
        
        public void createTestUser() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public List<Userentity> getBirthdaysToday() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

}
