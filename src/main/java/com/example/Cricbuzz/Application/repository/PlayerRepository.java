package com.example.Cricbuzz.Application.repository;

import com.example.Cricbuzz.Application.model.Player;
import com.example.Cricbuzz.Application.model.enums.Gender;
import com.example.Cricbuzz.Application.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    List<Player> findByGenderAndAgeGreaterThan(Gender gender, int age);

    @Query(value = "select * from player where gender = :gender AND speciality = :speciality",nativeQuery = true)
    List<Player> getByGenderAndSpeciality(String gender, String speciality);
}
