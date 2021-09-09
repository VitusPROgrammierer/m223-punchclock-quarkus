package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User add(User user) {
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam Long id){
        userService.delete(id);
    }

    @PUT
    public void updateUser(User user) {
        userService.update(user);
    }

}
