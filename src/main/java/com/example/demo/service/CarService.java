package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    // Method to get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();  // Fetch all cars from the database
    }

    // Method to save a car to the database
    public Car saveCar(Car car) {
        return carRepository.save(car);  // Saves the car to the database
    }

    public List<Car> searchCars(double length, double weight, double velocity, String color) {
        return carRepository.findByLengthAndWeightAndVelocityAndColor(length, weight, velocity, color);
    }
}
