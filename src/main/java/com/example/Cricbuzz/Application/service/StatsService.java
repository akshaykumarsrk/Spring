package com.example.Cricbuzz.Application.service;

import com.example.Cricbuzz.Application.converter.StatsConverter;
import com.example.Cricbuzz.Application.dto.request.StatsRequest;
import com.example.Cricbuzz.Application.dto.response.StatsResponse;
import com.example.Cricbuzz.Application.exception.PlayerNotFoundException;
import com.example.Cricbuzz.Application.model.Player;
import com.example.Cricbuzz.Application.model.Stats;
import com.example.Cricbuzz.Application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    @Autowired
    PlayerRepository playerRepository;

    public StatsResponse addStats(StatsRequest statsRequest, int playerId)
    {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if(optionalPlayer.isEmpty())
        {
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = optionalPlayer.get();

        Stats stats = StatsConverter.statsRequestToStats(statsRequest);

        player.setStats(stats);
        stats.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);   // save both player and stats

        return StatsConverter.statsToStatsResponse(savedPlayer.getStats());
    }
}
