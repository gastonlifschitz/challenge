package application.dto;

import application.models.Satellite;

import java.util.ArrayList;
import java.util.List;

public class SecretDTO {
    private List<Satellite> satellites = new ArrayList<>();
    /*public static SecretDTO fromUser(){
        final CreateUserDto dto = new CreateUserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        //DO NOT COPY PASSWORD
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        dto.setBirth(user.getBirth());
        dto.setDni(user.getDni());
        dto.setRole(user.getRole());
        dto.setGender(user.getGender());
        return dto;
    }*/
    private SecretDTO() {
        /* Required by JSON object mapper */
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }
}
