package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamesDTO {

    private Number appid;
    private String name;
    private Number playtime_2weeks;
    private String img_icon_url;
    private Number playtime_forever;
}
