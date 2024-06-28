package com.codewarrior.model;

import javax.persistence.*;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problemStatement;

    // getters and setters
}
