package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InfoGameResponseDTO {

    private String steamID;
    private String gameName;
    private List<StatDTO> stats;

}
