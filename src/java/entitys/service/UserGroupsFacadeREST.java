/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys.service;

import entitys.UserGroups;
import entitys.UserGroupsPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Aaron
 */
@Stateless
@Path("entitys.usergroups")
public class UserGroupsFacadeREST extends AbstractFacade<UserGroups> {
    @PersistenceContext(unitName = "DailyBankRestPU")
    private EntityManager em;

    private UserGroupsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;userEmail=userEmailValue;userRoll=userRollValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entitys.UserGroupsPK key = new entitys.UserGroupsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> userEmail = map.get("userEmail");
        if (userEmail != null && !userEmail.isEmpty()) {
            key.setUserEmail(userEmail.get(0));
        }
        java.util.List<String> userRoll = map.get("userRoll");
        if (userRoll != null && !userRoll.isEmpty()) {
            key.setUserRoll(userRoll.get(0));
        }
        return key;
    }

    public UserGroupsFacadeREST() {
        super(UserGroups.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UserGroups entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(UserGroups entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entitys.UserGroupsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UserGroups find(@PathParam("id") PathSegment id) {
        entitys.UserGroupsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserGroups> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserGroups> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
