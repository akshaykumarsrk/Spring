package com.example.Cricbuzz.Application.controller;

import com.example.Cricbuzz.Application.dto.request.StatsRequest;
import com.example.Cricbuzz.Application.dto.response.StatsResponse;
import com.example.Cricbuzz.Application.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    @PostMapping("/addStats/{player-id}")
    public StatsResponse addStats(@RequestBody StatsRequest statsRequest,
                                  @PathVariable("player-id") int playerId)
    {
        return statsService.addStats(statsRequest, playerId);
    }
}
