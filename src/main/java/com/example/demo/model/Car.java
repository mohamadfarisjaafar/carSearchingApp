package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude null fields from XML
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JacksonXmlProperty(isAttribute = true)  // Make these properties XML attributes
    private double length;
    @JacksonXmlProperty(isAttribute = true)
    private double weight;
    @JacksonXmlProperty(isAttribute = true)
    private double velocity;
    @JacksonXmlProperty(isAttribute = true)
    private String color;

    // Getter and Setter for length

    @XmlElement
    public Long getId() {
        return id;
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Getter and Setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getter and Setter for velocity
    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Optional: ToString method to easily print car details
    @Override
    public String toString() {
        return "Car{id=" + id + ", length=" + length + ", weight=" + weight + ", velocity=" + velocity + ", color='" + color + "'}";
    }
}
