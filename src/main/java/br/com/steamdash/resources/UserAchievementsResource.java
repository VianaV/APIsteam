package br.com.steamdash.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

import br.com.steamdash.restClients.dto.response.UserAchievementsRestResponseDTO;
import br.com.steamdash.restClients.dto.response.AchievementsDTO;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.steamdash.restClients.services.UserAchievementsRestService;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

@Path("/conquistas")
public class UserAchievementsResource {

    @Inject

    @RestClient
    UserAchievementsRestService achievementsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserAchievements() {
        try {
            UserAchievementsRestResponseDTO responseAchievements = achievementsService.getAchievements(730, "EE3EBD53957C0BB2035BD097B74FABA3",
                    "76561198185310634", "brazilian");

            List<AchievementsDTO> lista = responseAchievements.getPlayerstats().getAchievements();

            lista.forEach(item -> {
                LocalDateTime dataFormatada = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(item.getUnlocktime())), TimeZone.getDefault().toZoneId());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                item.setUnlocktime(dataFormatada.format(formatter));
            });

            return Response.ok(responseAchievements).build();
        }catch (ResteasyWebApplicationException e) {
            System.out.println(e);
            return Response.status(HttpStatus.SC_BAD_REQUEST).build();
        }
    }
}
