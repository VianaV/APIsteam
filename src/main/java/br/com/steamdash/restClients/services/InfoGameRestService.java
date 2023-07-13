package br.com.steamdash.restClients.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


import br.com.steamdash.restClients.dto.response.InfoGameRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient
public interface InfoGameRestService {

    @GET
    public InfoGameRestResponseDTO getInfoGame(
            @QueryParam("appid") Number appid,
            @QueryParam("key") String key,
            @QueryParam("steamid") String steamId);
           // @QueryParam("format") @DefaultValue("json") String json);
}
