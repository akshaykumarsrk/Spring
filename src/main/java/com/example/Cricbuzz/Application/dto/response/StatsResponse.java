package com.example.Cricbuzz.Application.dto.response;

import com.example.Cricbuzz.Application.model.Player;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatsResponse
{

    int runs;

    int wickets;

    PlayerResponse player;
}
