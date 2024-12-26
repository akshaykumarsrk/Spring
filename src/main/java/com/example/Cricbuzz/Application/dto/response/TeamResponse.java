package com.example.Cricbuzz.Application.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponse {

    String name;

    int ranking;

    String coach;
}
