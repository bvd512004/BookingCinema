package com.duc.cinebook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "email",nullable = false, unique = true)
    String email;

    @Column(name = "password",nullable = false)
    String password;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "loyalty_points")
    int loyaltyPoints = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles;
}
