package com.example.Cricbuzz.Application.service;

import com.example.Cricbuzz.Application.converter.MatchConverter;
import com.example.Cricbuzz.Application.dto.request.MatchRequest;
import com.example.Cricbuzz.Application.dto.response.MatchResponse;
import com.example.Cricbuzz.Application.exception.TeamNotFoundException;
import com.example.Cricbuzz.Application.model.CricketMatch;
import com.example.Cricbuzz.Application.model.Team;
import com.example.Cricbuzz.Application.repository.MatchRepository;
import com.example.Cricbuzz.Application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId)
    {
        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if ((optionalTeamA.isEmpty()) || optionalTeamB.isEmpty())
        {
            throw new TeamNotFoundException("One or more team id(s) is not valid");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConverter.matchRequestToMatch(matchRequest);
        match.getTeams().add(teamA);
        match.getTeams().add(teamB);

        teamA.setMatchesPlayed(teamA.getMatchesPlayed()+1);
        teamA.getMatches().add(match);

        teamB.setMatchesPlayed(teamB.getMatchesPlayed()+1);
        teamB.getMatches().add(match);

        CricketMatch cricketMatch = matchRepository.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConverter.matchToMatchRespone(cricketMatch);
    }
}
