package com.example.Cricbuzz.Application.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchResponse {

    String title;

    String venue;

    Date created;

    List<TeamResponse> teams;
}
