package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AchievementsDTO {

    private String apiname;
    private String achieved;
    private String unlocktime;
    private String name;
    private String description;

}