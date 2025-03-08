package com.keyin.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")  // Defines the table name in the database
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airport> airports;

    // 🔹 Default Constructor (Required by JPA)
    public City() {}

    // 🔹 Parameterized Constructor
    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // 🔹 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }

    // 🔹 Override toString() for Debugging
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
