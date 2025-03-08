package com.keyin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")  // Maps this entity to the "airports" table in the database
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @Column(nullable = false)
    private String city;

    // 🔹 Default Constructor (Required by JPA)
    public Airport() {}

    // Add this constructor to match the test case
    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // 🔹 Parameterized Constructor
    public Airport(String name, String code, String city) {
        this.name = name;
        this.code = code;
        this.city = city;
    }

    // 🔹 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    // 🔹 Override toString() for debugging/logging
    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
