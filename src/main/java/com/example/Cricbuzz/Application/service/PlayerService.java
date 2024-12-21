package com.example.Cricbuzz.Application.service;

import com.example.Cricbuzz.Application.converter.PlayerConverter;
import com.example.Cricbuzz.Application.dto.request.PlayerRequest;
import com.example.Cricbuzz.Application.dto.response.PlayerResponse;
import com.example.Cricbuzz.Application.model.Player;
import com.example.Cricbuzz.Application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {


        Player player = PlayerConverter.playerRequetToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        return PlayerConverter.playerToPlayerResponse(savedPlayer);
    }
}
