package com.duc.cinebook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    Showtime showtime;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    Voucher voucher;

    @Column(name = "total_amount")
    double totalAmount;

    @Column(name = "status")
    String status;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
