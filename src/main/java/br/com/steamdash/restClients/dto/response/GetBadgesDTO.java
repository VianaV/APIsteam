package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBadgesDTO {


    private String badgeid;
    private String level;
    private String completion_time;
    private String xp;
    private String scarcity;
}
