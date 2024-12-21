package com.example.Cricbuzz.Application.dto.request;

import com.example.Cricbuzz.Application.model.enums.Gender;
import com.example.Cricbuzz.Application.model.enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    String name;

    int age;

    Speciality speciality;

    Gender gender;
}
