package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Ticket;
import ch.zli.m223.punchclock.service.TicketService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "Ticket", description = "Sample to manage tickets")
@RolesAllowed("User")
@Path("/tickets")
public class TicketController {

    @Inject
    TicketService ticketService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> list() {
        return ticketService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Ticket add(Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTicket(@PathParam Long id){
        ticketService.delete(id);
    }

    @PUT
    public void updateTicket(Ticket ticket) {
        ticketService.update(ticket);
    }

}
