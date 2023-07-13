package br.com.steamdash.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.steamdash.config.ConfigProperties;
import br.com.steamdash.restClients.services.JogosRecentesRestService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/jogosRecentes")
public class JogosRecentesResource {

    @Inject
    ConfigProperties config;

    @Inject
    @RestClient
    JogosRecentesRestService jogosRecentesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findJogosRecentes(@QueryParam("steamId") String steamId) {

        var responseJogos = jogosRecentesService
                .getJogosRecentes(config.apiKeySteam(), steamId,"json");

          return Response.ok(responseJogos.getResponse().getGames()).build();
    }




}
