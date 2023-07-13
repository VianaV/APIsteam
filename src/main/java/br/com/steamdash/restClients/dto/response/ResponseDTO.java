package br.com.steamdash.restClients.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private List<PlayerResponseDTO> players;

}
