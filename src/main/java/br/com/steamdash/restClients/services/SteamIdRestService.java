package br.com.steamdash.restClients.services;


import br.com.steamdash.restClients.dto.response.SteamIdRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
@RegisterRestClient
public interface SteamIdRestService {

    @GET
    SteamIdRestResponseDTO getProfile(
            @QueryParam("key") String key,
            @QueryParam("vanityurl") String vanityurl,
            @QueryParam("format") @DefaultValue("json") String json);
}
