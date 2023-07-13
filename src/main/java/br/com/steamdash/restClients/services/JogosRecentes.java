package br.com.steamdash.restClients.services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.com.steamdash.restClients.dto.response.JogosRecentesRestResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient

public interface JogosRecentes {
    
    @GET
    public JogosRecentesRestResponseDTO getJogosRecentes(
    @QueryParam("key") String key,
    @QueryParam("steamid") String steamId,
    @QueryParam("format") String format);

}
