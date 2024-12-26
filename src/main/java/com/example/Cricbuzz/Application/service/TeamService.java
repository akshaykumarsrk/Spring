package com.example.Cricbuzz.Application.service;

import com.example.Cricbuzz.Application.converter.TeamConverter;
import com.example.Cricbuzz.Application.dto.request.TeamRequest;
import com.example.Cricbuzz.Application.dto.response.TeamResponse;
import com.example.Cricbuzz.Application.model.Team;
import com.example.Cricbuzz.Application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest)
    {
        Team team = TeamConverter.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        return TeamConverter.teamToTeamResponse(savedTeam);
    }
}
