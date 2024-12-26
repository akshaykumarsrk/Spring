package com.example.Cricbuzz.Application.controller;

import com.example.Cricbuzz.Application.dto.request.MatchRequest;
import com.example.Cricbuzz.Application.exception.TeamNotFoundException;
import com.example.Cricbuzz.Application.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping("/registerMatch/{teamA-id}/{teamB-id}")
    public ResponseEntity registerMatch(@RequestBody MatchRequest matchRequest,
                                        @PathVariable("teamA-id") int teamAId,
                                        @PathVariable("teamB-id") int teamBId)
    {
        try {
            return new ResponseEntity<>(matchService.registerMatch(matchRequest, teamAId, teamBId), HttpStatus.CREATED);
        }
        catch (TeamNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
