package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Friends {

    private String steamid;
    private String relationship;
    private Number friend_since;

}
