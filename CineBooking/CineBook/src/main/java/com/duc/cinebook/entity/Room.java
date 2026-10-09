package com.duc.cinebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "room_name", nullable = false)
    String roomName;

    @Column(name = "total_seats")
    int totalSeats;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnore
    Cinema cinema;
}
