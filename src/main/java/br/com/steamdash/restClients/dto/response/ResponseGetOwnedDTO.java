package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResponseGetOwnedDTO {

    private String game_count;
    private List<GetOwnedDTO> games;

}
