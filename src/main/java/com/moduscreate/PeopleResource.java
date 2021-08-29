package com.moduscreate;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/people")
public class PeopleResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(People people) {
        people.persist();
        return Response.created(URI.create(String.format("/people/%s", people.id))).entity(people).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<People> findByStatus(@QueryParam("status") PeopleStatus peopleStatus) {
        return People.findByStatus(peopleStatus);
    }
}
