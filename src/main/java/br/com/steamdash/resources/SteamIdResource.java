package br.com.steamdash.resources;

import br.com.steamdash.config.ConfigProperties;
import br.com.steamdash.dto.response.SteamIdResponseDTO;
import br.com.steamdash.restClients.services.SteamIdRestService;
import br.com.steamdash.restClients.dto.response.SteamIdRestResponseDTO;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/steamId")
public class SteamIdResource {
    @Inject
    @RestClient
    SteamIdRestService restService;

    @Inject
    ConfigProperties config;

    @GET
    @Path("/{perfil}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findSteamId(@PathParam("perfil") String perfil){

        try{
            SteamIdRestResponseDTO response = restService.getProfile(config.apiKeySteam(), perfil, "json");
            if(response.getResponse().getSuccess() == 1){
                SteamIdResponseDTO responseDTO = new SteamIdResponseDTO();
                responseDTO.setSteamid(response.getResponse().getSteamid());
                return Response.ok(responseDTO).build();
            }else{
                return Response.status(HttpStatus.SC_NOT_FOUND).build();
            }
        }catch (ResteasyWebApplicationException e){
            System.out.println("Erro na chamada" +e);
            return Response.status(HttpStatus.SC_BAD_REQUEST).build();
        }
    }
}
