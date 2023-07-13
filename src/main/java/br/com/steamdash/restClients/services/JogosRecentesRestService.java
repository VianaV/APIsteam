package br.com.steamdash.restClients.services;

import br.com.steamdash.restClients.dto.response.JogosRecentesRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
@RegisterRestClient

public interface JogosRecentesRestService {

    @GET
    public JogosRecentesRestResponseDTO getJogosRecentes(
            @QueryParam("key") String key,
            @QueryParam("steamid") String steamId,
            @QueryParam("format") @DefaultValue("json") String json);
}
