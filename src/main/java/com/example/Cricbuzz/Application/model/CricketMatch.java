package com.example.Cricbuzz.Application.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String venue;

    @CreationTimestamp
    Date created;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "match_team",
    joinColumns = @JoinColumn(name = "match_id"),
    inverseJoinColumns = @JoinColumn(name = "team_id"))

    // manyToMany case third table willbe foreign key i.e join table
    List<Team> teams;
}
