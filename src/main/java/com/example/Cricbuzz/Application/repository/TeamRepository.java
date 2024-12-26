package com.example.Cricbuzz.Application.repository;

import com.example.Cricbuzz.Application.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
