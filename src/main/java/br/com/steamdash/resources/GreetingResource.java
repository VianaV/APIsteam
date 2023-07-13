package br.com.steamdash.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// import io.quarkus.security.Authenticated;

@Path("/hello")
public class GreetingResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // @Authenticated
    public String hello() {
        return "Hello Easy";
    }
}