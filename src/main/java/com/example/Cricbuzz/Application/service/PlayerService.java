package com.example.Cricbuzz.Application.service;

import com.example.Cricbuzz.Application.converter.PlayerConverter;
import com.example.Cricbuzz.Application.dto.request.PlayerRequest;
import com.example.Cricbuzz.Application.dto.response.PlayerResponse;
import com.example.Cricbuzz.Application.exception.PlayerNotFoundException;
import com.example.Cricbuzz.Application.model.Player;
import com.example.Cricbuzz.Application.model.enums.Gender;
import com.example.Cricbuzz.Application.model.enums.Speciality;
import com.example.Cricbuzz.Application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {


        Player player = PlayerConverter.playerRequetToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        return PlayerConverter.playerToPlayerResponse(savedPlayer);
    }

    public PlayerResponse getPlayerById(int id)
    {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if(playerOptional.isEmpty())
        {
            throw new PlayerNotFoundException("Player with id: "+id+ " doesn't exist");
        }
        return PlayerConverter.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> getByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Player> players = playerRepository.findByGenderAndAgeGreaterThan(gender, age);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (Player player : players)
        {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }

    public List<PlayerResponse> getByGenderAndSpeciality(String gender, String speciality) {
        List<Player> players = playerRepository.getByGenderAndSpeciality(gender, speciality);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (Player player : players)
        {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }
}
