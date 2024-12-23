package com.example.Cricbuzz.Application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StatsRequest {

    int runs;

    int wickets;

    double battingAvg;

    double bowlingAvg;

    // keep dto as pure as you can
    // so playerId is not a part of stats, it is just a foreign key connected to player
    // so instead of write playerId in dto, add it @RequestParam("playerId) in the StstsController methods()
    //    int playerId;
}
