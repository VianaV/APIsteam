package br.com.steamdash.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.steamdash.restClients.dto.response.InfoGameResponseDTO;
import br.com.steamdash.restClients.dto.response.InfoGameRestResponseDTO;
import br.com.steamdash.restClients.dto.response.StatDTO;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import br.com.steamdash.restClients.services.InfoGameRestService;

import java.util.ArrayList;
import java.util.List;

@Path("/infoGame")
public class InfoGameResource {

    @Inject
    @RestClient
    InfoGameRestService infoGameService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findInfoGame() {

        try {
            InfoGameRestResponseDTO responseInfoGame = infoGameService.getInfoGame(730,
                    "EE3EBD53957C0BB2035BD097B74FABA3", "76561198185310634");

            InfoGameResponseDTO response = new InfoGameResponseDTO();
            List<StatDTO> lista = new ArrayList<>();

            List<StatDTO> listaInfoGame = responseInfoGame.getPlayerstats().getStats();

            response.setGameName(responseInfoGame.getPlayerstats().getGameName());
            response.setSteamID(responseInfoGame.getPlayerstats().getSteamID());
            listaInfoGame.forEach(gameInfo ->{
                StatDTO dados = new StatDTO();
                dados.setName(gameInfo.getName());
                dados.setValue(gameInfo.getValue());
                lista.add(dados);
            });
            response.setStats(lista);
            return Response.ok(response).build();
        } catch (ResteasyWebApplicationException e) {
            System.out.println(e);
            return Response.status(HttpStatus.SC_BAD_REQUEST).build();
        }

    }
}