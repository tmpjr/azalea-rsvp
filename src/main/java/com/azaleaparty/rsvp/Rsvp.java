package com.azaleaparty.rsvp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "rsvp")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "kids", nullable = false)
    private int kids;

    @Column(name = "adults", nullable = false)
    private int adults;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

}
