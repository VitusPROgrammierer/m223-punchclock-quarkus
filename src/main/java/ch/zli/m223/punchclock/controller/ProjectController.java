package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "Project", description = "Manage projects")
@Path("/projects")
@RolesAllowed("User")
public class ProjectController {

    @Inject
    ProjectService projectService;

    /**
     * @return list of all projects
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> list() {
        return projectService.findAll();
    }

    /**
     * @param project new project to add to db
     * @return project which got added
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Project add(Project project) {
        return projectService.createProject(project);
    }

    /**
     * @param id id of project to get deleted
     */
    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam Long id){
        projectService.delete(id);
    }

    /**
     * @param project project to get updated
     */
    @PUT
    public void updateProject(Project project) {
        projectService.update(project);
    }

}
