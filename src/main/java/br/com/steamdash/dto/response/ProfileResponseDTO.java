package br.com.steamdash.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponseDTO {
    
    private String steamId;
    private String name;
    private String urlAvatar;
    private String realName;
    private String pais;
    
}
