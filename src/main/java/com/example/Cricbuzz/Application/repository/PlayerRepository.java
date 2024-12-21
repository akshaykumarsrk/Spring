package com.example.Cricbuzz.Application.repository;

import com.example.Cricbuzz.Application.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
