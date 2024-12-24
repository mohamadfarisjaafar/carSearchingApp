package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private XmlMapper xmlMapper;  // XmlMapper for converting objects to XML


    // Endpoint to get all cars
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no cars are found
        }
        return ResponseEntity.ok(cars);  // Return 200 OK with the list of cars
    }

    // Endpoint for inserting a car
    @PostMapping("/insert")
    public ResponseEntity<Car> insertCar(@RequestBody Car car) {
        // Validate if any field is missing (optional)
        if (car.getLength() <= 0 || car.getWeight() <= 0 || car.getVelocity() <= 0 || car.getColor().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Car savedCar = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @GetMapping("/search")
    public List<Car> searchCars(
            @RequestParam double length,
            @RequestParam double weight,
            @RequestParam double velocity,
            @RequestParam String color) {
        return carService.searchCars(length, weight, velocity, color);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadCarsAsXml(
            @RequestParam double length,
            @RequestParam double weight,
            @RequestParam double velocity,
            @RequestParam String color) {
        List<Car> cars = carService.searchCars(length, weight, velocity, color);
        String xml = convertToXml(cars);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setContentDispositionFormData("attachment", "cars.xml");
        return new ResponseEntity<>(xml, headers, HttpStatus.OK);
    }

    // Endpoint to download all cars in XML format
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCarsToXml() throws IOException {
        List<Car> cars = carService.getAllCars();

        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();  // No cars found, return 204 No Content
        }

        // Convert the list of cars to XML
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, cars);

        byte[] xmlData = byteArrayOutputStream.toByteArray();

        // Set headers to indicate the content type is XML and it's a downloadable file
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_XML);
        headers.setContentDispositionFormData("attachment", "cars.xml");

        return new ResponseEntity<>(xmlData, headers, HttpStatus.OK);  // Return the XML file as a downloadable response
    }

    private String convertToXml(List<Car> cars) {
        // Use a library like Jackson or JAXB to serialize the list to XML.
        return "<cars>" +
                cars.stream().map(car -> String.format(
                                "<car><length>%f</length><weight>%f</weight><velocity>%f</velocity><color>%s</color></car>",
                                car.getLength(), car.getWeight(), car.getVelocity(), car.getColor()))
                        .reduce("", String::concat) +
                "</cars>";
    }
}
