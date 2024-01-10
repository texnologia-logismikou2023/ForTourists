package com.example.fortourists;

// Class representing an attraction with name, description, latitude, and longitude
public class Attraction {

    // Fields to store the information about the attraction
    private String name;
    private String description;
    private double latitude;
    private double longitude;

    // Constructor to initialize the attraction with provided data
    public Attraction(String name, String description, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
