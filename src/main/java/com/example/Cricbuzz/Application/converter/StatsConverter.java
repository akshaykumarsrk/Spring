package com.example.Cricbuzz.Application.converter;

import com.example.Cricbuzz.Application.dto.request.StatsRequest;
import com.example.Cricbuzz.Application.dto.response.StatsResponse;
import com.example.Cricbuzz.Application.model.Stats;

public class StatsConverter {

    public static Stats statsRequestToStats(StatsRequest statsRequest)
    {
        return Stats.builder()
                .runs(statsRequest.getRuns())
                .wickets(statsRequest.getWickets())
                .battingAvg(statsRequest.getBattingAvg())
                .bowlingAvg(statsRequest.getBowlingAvg())
                .build();
    }

    public static StatsResponse statsToStatsResponse(Stats stats)
    {
        return StatsResponse.builder()
                .runs(stats.getRuns())
                .wickets(stats.getWickets())
                .player(PlayerConverter.playerToPlayerResponse(stats.getPlayer()))
                .build();
    }
}
