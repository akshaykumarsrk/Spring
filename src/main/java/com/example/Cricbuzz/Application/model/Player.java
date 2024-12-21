package com.example.Cricbuzz.Application.model;

import com.example.Cricbuzz.Application.model.enums.Gender;
import com.example.Cricbuzz.Application.model.enums.Speciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Speciality speciality;
    // by default Database treat ENUMS as integer

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "player")
    Stats stats;

    @ManyToOne
    Team team;
}
