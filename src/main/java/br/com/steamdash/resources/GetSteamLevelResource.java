package br.com.steamdash.resources;

import br.com.steamdash.restClients.dto.response.GetSteamLevelRestResponseDTO;
import br.com.steamdash.restClients.services.GetSteamLevelRestService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/steamLevel")
public class GetSteamLevelResource {

    @Inject

    @RestClient
    GetSteamLevelRestService SteamLevelService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGetSteamLevel () {

        GetSteamLevelRestResponseDTO responseGetSteam = SteamLevelService.getSteamLevel("EE3EBD53957C0BB2035BD097B74FABA3",
                "76561198185310634");

        System.out.println("responseGetSteam"+ responseGetSteam);

        return Response.ok(responseGetSteam).build();



    }







}
