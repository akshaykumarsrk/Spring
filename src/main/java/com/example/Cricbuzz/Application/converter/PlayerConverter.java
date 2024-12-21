package com.example.Cricbuzz.Application.converter;

import com.example.Cricbuzz.Application.dto.request.PlayerRequest;
import com.example.Cricbuzz.Application.dto.response.PlayerResponse;
import com.example.Cricbuzz.Application.model.Player;

public class PlayerConverter {

    public static Player playerRequetToPlayer(PlayerRequest playerRequest){
        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .speciality(playerRequest.getSpeciality())
                .gender(playerRequest.getGender())
                .build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player){
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}
