package br.com.steamdash.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.steamdash.config.ConfigProperties;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import br.com.steamdash.dto.response.ProfileResponseDTO;
import br.com.steamdash.restClients.dto.response.ProfileRestResponseDTO;
import br.com.steamdash.restClients.services.ProfileRestService;

@Path("/profile")
public class ProfileResource {

    @Inject
    @RestClient
    ProfileRestService profileService;

    @Inject
    ConfigProperties config;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProfile(@QueryParam("steamId") String steamId) {

        try {
            ProfileRestResponseDTO responseProfile = profileService.getProfile(config.apiKeySteam(),
                    steamId,
                    "json");

            ProfileResponseDTO response = new ProfileResponseDTO();

            responseProfile.getResponse().getPlayers().forEach(player -> {
                response.setName(player.getPersonaname());
                response.setSteamId(player.getSteamid());
                response.setRealName(player.getRealname());
                response.setUrlAvatar(player.getAvatarfull());
                response.setPais(player.getLoccountrycode());
            });

            return Response.ok(response).build();
        } catch (ResteasyWebApplicationException e) {
            return Response.status(HttpStatus.SC_BAD_REQUEST).build();
        }

    }
}