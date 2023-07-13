package br.com.steamdash.restClients.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ListaAmigosResponseDadosDTO {
    private List<Friends> friends;
}
