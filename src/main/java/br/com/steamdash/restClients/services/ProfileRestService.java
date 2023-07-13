package br.com.steamdash.restClients.services;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.steamdash.restClients.dto.response.ProfileRestResponseDTO;

@Path("/")
@RegisterRestClient
public interface ProfileRestService {

    @GET
    public ProfileRestResponseDTO getProfile(
            @QueryParam("key") String key,
            @QueryParam("steamids") String steamId,
            @QueryParam("format") @DefaultValue("json") String json);
}
