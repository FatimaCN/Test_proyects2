package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Plant;
import com.example.demo.service.PlantService;

import domain.PlantRequest;
 
@RestController
@RequestMapping("/plants")
public class PlantController 
{
    @Autowired
    PlantService service;
    
    @GetMapping
    public ResponseEntity<List<Plant>> getAllEmployees() {
        List<Plant> list = service.getAllPlants();
 
        return new ResponseEntity<List<Plant>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        Plant entity = service.getPlantById(id);
 
        return new ResponseEntity<Plant>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Plant> createPlants(@RequestBody PlantRequest plant)
                                                    throws RecordNotFoundException {
        Plant save = service.createPlants(plant);
        return new ResponseEntity<Plant>(save, new HttpHeaders(), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Plant> updatePlants(@RequestBody Plant plant)
                                                    throws RecordNotFoundException {
        Plant updated = service.updatePlants(plant);
        return new ResponseEntity<Plant>(updated, new HttpHeaders(), HttpStatus.CREATED);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deletePlantById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        service.deletePlantById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}