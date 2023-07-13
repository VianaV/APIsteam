package br.com.steamdash.resources;

import br.com.steamdash.config.ConfigProperties;
import br.com.steamdash.restClients.dto.response.ListaAmigosResponseDTO;
import br.com.steamdash.restClients.dto.response.ProfileRestResponseDTO;
import br.com.steamdash.restClients.services.ListaAmigosRestService;
import br.com.steamdash.restClients.services.ProfileRestService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/listaAmigos")
public class ListaAmigosResource {

    @Inject
    ConfigProperties config;

    @Inject
    @RestClient
    ListaAmigosRestService service;

    @Inject
    @RestClient
    ProfileRestService serviceProfile;

    String steamIds = "";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaAmigos(@QueryParam("steamId") String steamId,
                                @QueryParam("relacao") @DefaultValue("friend") String relacao){

        steamIds = "";

        ListaAmigosResponseDTO response = service.getListaAmigos(config.apiKeySteam(), steamId, relacao);

        response.getFriendslist().getFriends().forEach(item ->{
            steamIds  = steamIds.concat(item.getSteamid() + ",");
        });

        ProfileRestResponseDTO responseProfile = serviceProfile.getProfile(config.apiKeySteam(),steamIds, "json");

        return Response.ok(responseProfile.getResponse().getPlayers()).build();
    }
}
