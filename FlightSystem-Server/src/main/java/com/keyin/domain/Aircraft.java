package com.keyin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "aircrafts")  // Defines the table name in the database
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String model;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int capacity;

    // 🔹 Default Constructor (Required by JPA)
    public Aircraft() {}

    // 🔹 Parameterized Constructor
    public Aircraft(String model, String manufacturer, int capacity) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
    }

    // 🔹 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // 🔹 Override toString() for Debugging
    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
