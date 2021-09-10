package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "User", description = "Manage users")
@RolesAllowed("User")
@Path("/users")
public class UserController {

    @Inject
    UserService userService;

    /**
     * @return list of all users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userService.findAll();
    }

    /**
     * @param user new user to add to db
     * @return user who got added
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User add(User user) {
        return userService.createUser(user);
    }

    /**
     * @param id id of user to get deleted
     */
    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam Long id){
        userService.delete(id);
    }

    /**
     * @param user user to get updated
     */
    @PUT
    public void updateUser(User user) {
        userService.update(user);
    }

}
