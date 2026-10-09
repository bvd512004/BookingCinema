package com.duc.cinebook.entity;

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
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;

    @Column(name = "seat_row")
    String seatRow;

    @Column(name = "seat_number")
    int seatNumber;

    @Column(name = "seat_type")
    String seatType; // e.g., STANDARD, VIP, COUPLE
}
