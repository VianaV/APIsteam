package br.com.steamdash.restClients.services;

import br.com.steamdash.restClients.dto.response.GetBadgesRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
@RegisterRestClient

public interface GetBadgesRestService {

    @GET
    public GetBadgesRestResponseDTO getBadges (
            @QueryParam("key") String key,
            @QueryParam("steamid") String steamId);


}
