package br.com.steamdash.restClients.services;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.steamdash.restClients.dto.response.UserAchievementsRestResponseDTO;


@Path("/")
@RegisterRestClient
public interface UserAchievementsRestService {

    @GET
    public UserAchievementsRestResponseDTO getAchievements(
            @QueryParam("appid") Number appid,
            @QueryParam("key") String key,
            @QueryParam("steamid") String steamid,
            @QueryParam("l") @DefaultValue("brazilian") String idioma);
}
