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
import com.example.demo.model.PlantsEntity;
import com.example.demo.service.PlantsService;
 
@RestController
@RequestMapping("/plants")
public class PlantsController 
{
    @Autowired
    PlantsService service;
 
    @GetMapping
    public ResponseEntity<List<PlantsEntity>> getAllEmployees() {
        List<PlantsEntity> list = service.getAllPlants();
 
        return new ResponseEntity<List<PlantsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<PlantsEntity> getPlantById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        PlantsEntity entity = service.getPlantById(id);
 
        return new ResponseEntity<PlantsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<PlantsEntity> createPlants(@RequestBody PlantsEntity plant)
                                                    throws RecordNotFoundException {
        PlantsEntity save = service.createPlants(plant);
        return new ResponseEntity<PlantsEntity>(save, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<PlantsEntity> updatePlants(@RequestBody PlantsEntity plant)
                                                    throws RecordNotFoundException {
        PlantsEntity updated = service.updatePlants(plant);
        return new ResponseEntity<PlantsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deletePlantById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        service.deletePlantById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}