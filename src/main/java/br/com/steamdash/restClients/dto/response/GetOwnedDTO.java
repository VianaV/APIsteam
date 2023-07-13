package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOwnedDTO {

    private String appid;
    private String playtime_forever;
    private String playtime_windows_forever;
    private String playtime_mac_forever;
    private String playtime_linux_forever;
    private String rtime_last_played;

}
