package com.example.Cricbuzz.Application.repository;

import com.example.Cricbuzz.Application.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<CricketMatch, Integer> {
}
