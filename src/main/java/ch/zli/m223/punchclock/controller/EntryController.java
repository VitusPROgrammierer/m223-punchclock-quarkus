package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "Entry", description = "Manage entries")
@Path("/entries")
@RolesAllowed("User")
public class EntryController {

    @Inject
    EntryService entryService;

    /**
     * @return list of all entries
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entry> list() {
        return entryService.findAll();
    }

    /**
     * @param entry new entry to add to db
     * @return entry which got added
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    /**
     * @param id id of entry to get deleted
     */
    @DELETE
    @Path("/{id}")
    public void deleteEntry(@PathParam Long id){
        entryService.delete(id);
    }

    /**
     * @param entry entry to get updated
     */
    @PUT
    public void updateEntry(Entry entry) {
        entryService.update(entry);
    }

}
