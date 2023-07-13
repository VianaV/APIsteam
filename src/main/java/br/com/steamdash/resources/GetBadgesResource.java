package br.com.steamdash.resources;

import br.com.steamdash.restClients.dto.response.GetBadgesRestResponseDTO;
import br.com.steamdash.restClients.services.GetBadgesRestService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/insignas")
public class GetBadgesResource {


    @Inject

    @RestClient
    GetBadgesRestService GetBadgesServices;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGetBadges () {


        GetBadgesRestResponseDTO responseGetBadges = GetBadgesServices.getBadges("EE3EBD53957C0BB2035BD097B74FABA3",
                "76561198185310634");


        System.out.println(" responseGetBadges"+ responseGetBadges);

        return Response.ok(responseGetBadges).build();
    }


}
