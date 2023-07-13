package br.com.steamdash.resources;

import br.com.steamdash.restClients.dto.response.GetOwnedRestResponseDTO;
import br.com.steamdash.restClients.services.GetOwnedGamesRestService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogosComprados")
public class GetOwnedGamesResource {

    @Inject

    @RestClient
    GetOwnedGamesRestService GetOwnedService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGetOwnedGames () {


        GetOwnedRestResponseDTO responseGetOwned = GetOwnedService.getOwnedGames("EE3EBD53957C0BB2035BD097B74FABA3",
                "76561198185310634",
                "json");

        System.out.println(" responseGetOwned"+ responseGetOwned);

        return Response.ok(responseGetOwned).build();
    }




}

