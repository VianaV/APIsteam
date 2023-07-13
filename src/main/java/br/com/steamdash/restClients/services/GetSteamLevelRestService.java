package br.com.steamdash.restClients.services;

import br.com.steamdash.restClients.dto.response.GetSteamLevelRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
@RegisterRestClient

public interface GetSteamLevelRestService {

    @GET
    public GetSteamLevelRestResponseDTO getSteamLevel(
            @QueryParam("key") String key,
            @QueryParam("steamid") String steamId);

}
