package com.example.Cricbuzz.Application.converter;

import com.example.Cricbuzz.Application.dto.request.MatchRequest;
import com.example.Cricbuzz.Application.dto.response.MatchResponse;
import com.example.Cricbuzz.Application.dto.response.TeamResponse;
import com.example.Cricbuzz.Application.model.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConverter {

    public static CricketMatch matchRequestToMatch(MatchRequest matchRequest)
    {
        return CricketMatch.builder()
                .title(matchRequest.getTitle())
                .venue(matchRequest.getVenue())
                .teams(new ArrayList<>())
                .build();
    }

    public static MatchResponse matchToMatchRespone(CricketMatch cricketMatch)
    {

        List<TeamResponse> teams = new ArrayList<>();
        teams.add(TeamConverter.teamToTeamResponse(cricketMatch.getTeams().get(0)));
        teams.add(TeamConverter.teamToTeamResponse(cricketMatch.getTeams().get(1)));


        return MatchResponse.builder()
                .title(cricketMatch.getTitle())
                .venue(cricketMatch.getVenue())
                .created(cricketMatch.getCreated())
                .teams(teams)
                .build();
    }
}
