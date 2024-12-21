package com.example.Cricbuzz.Application.dto.response;

import com.example.Cricbuzz.Application.model.enums.Speciality;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerResponse {

    String name;

    Speciality speciality;
}
