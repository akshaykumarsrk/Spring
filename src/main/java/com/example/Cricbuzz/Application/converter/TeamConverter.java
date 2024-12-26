package com.example.Cricbuzz.Application.converter;

import com.example.Cricbuzz.Application.dto.request.TeamRequest;
import com.example.Cricbuzz.Application.dto.response.TeamResponse;
import com.example.Cricbuzz.Application.model.Team;

public class TeamConverter {

    public static Team teamRequestToTeam(TeamRequest teamRequest)
    {
        return Team.builder()
                .name(teamRequest.getName())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .coach(teamRequest.getCoach())
                .matchesPlayed(0)
                .build();
    }

    public static TeamResponse teamToTeamResponse(Team team)
    {
        return TeamResponse.builder()
                .name(team.getName())
                .ranking(team.getRanking())
                .coach(team.getCoach())
                .build();
    }
}
