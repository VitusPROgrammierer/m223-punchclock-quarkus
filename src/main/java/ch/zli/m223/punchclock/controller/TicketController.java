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

@Tag(name = "Ticket", description = "Manage tickets")
@RolesAllowed("User")
@Path("/tickets")
public class TicketController {

    @Inject
    TicketService ticketService;

    /**
     * @return list of all tickets
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> list() {
        return ticketService.findAll();
    }

    /**
     * @param ticket new ticket to add to db
     * @return ticket which got added
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Ticket add(Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    /**
     * @param id id of ticket to get deleted
     */
    @DELETE
    @Path("/{id}")
    public void deleteTicket(@PathParam Long id){
        ticketService.delete(id);
    }

    /**
     * @param ticket ticket to get updated
     */
    @PUT
    public void updateTicket(Ticket ticket) {
        ticketService.update(ticket);
    }

}
