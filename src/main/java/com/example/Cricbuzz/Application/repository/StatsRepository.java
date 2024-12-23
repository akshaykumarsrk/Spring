package com.example.Cricbuzz.Application.repository;

import com.example.Cricbuzz.Application.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats,Integer> {
}
