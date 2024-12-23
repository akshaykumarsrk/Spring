package com.example.Cricbuzz.Application.controller;

import com.example.Cricbuzz.Application.dto.request.PlayerRequest;
import com.example.Cricbuzz.Application.dto.response.PlayerResponse;
import com.example.Cricbuzz.Application.model.enums.Gender;
import com.example.Cricbuzz.Application.model.enums.Speciality;
import com.example.Cricbuzz.Application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/addPlayer")
    public PlayerResponse addPlayer(@RequestBody PlayerRequest playerRequest)
    {
        return playerService.addPlayer(playerRequest);
    }

    @GetMapping("/id/{id}")
    public PlayerResponse getPlayerById(@PathVariable("id") int id)
    {
        return playerService.getPlayerById(id);
    }

    // gender and age -> Male, 35 >= 35
    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getByGenderAndAgeGreaterThan(@PathVariable("gender")Gender gender,
                                                             @PathVariable("age") int age)
    {
        return playerService.getByGenderAndAgeGreaterThan(gender, age);
    }

    // speciality, gender
    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable("gender") String gender,
                                                         @PathVariable("speciality") String speciality)
    {
        return playerService.getByGenderAndSpeciality(gender, speciality);
    }
}
