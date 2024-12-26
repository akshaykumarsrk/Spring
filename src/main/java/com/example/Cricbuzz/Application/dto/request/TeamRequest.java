package com.example.Cricbuzz.Application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {

    String name;

    int ranking;

    int iccPoints;

    String coach;
}
