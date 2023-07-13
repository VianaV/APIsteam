package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseGetBadgeDTO {


    private List<GetBadgesDTO> badges;
    private String player_xp;
    private String player_level;

    private String player_xp_needed_to_level_up;

    private String player_xp_needed_current_level;


}
