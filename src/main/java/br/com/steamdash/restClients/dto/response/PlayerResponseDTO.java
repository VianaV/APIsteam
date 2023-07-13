package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponseDTO {

    private String steamid;
    private String personaname;
    private String realname;
    private String avatarfull;
    private String loccountrycode;

}
