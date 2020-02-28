package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.PlantsEntity;
import com.example.demo.repository.PlantsRepository;
 
@Service
public class PlantsService {
     
    @Autowired
    PlantsRepository repository;
     
    public List<PlantsEntity> getAllPlants()
    {
        List<PlantsEntity> plantsList = repository.findAll();
         
        if(plantsList.size() > 0) {
            return plantsList;
        } else {
            return new ArrayList<PlantsEntity>();
        }
    }
     
    public PlantsEntity getPlantById(int id) throws RecordNotFoundException 
    {
        Optional<PlantsEntity> plant = repository.findById(id);
         
        if(plant.isPresent()) {
            return plant.get();
        } else {
            throw new RecordNotFoundException("No plant record exist for given id");
        }
    }
     
    public PlantsEntity createPlants(PlantsEntity entity) throws RecordNotFoundException 
    {
    	Optional<PlantsEntity> plant =repository.findById(entity.getId());
    	
    	if(plant.isPresent()) {
    		throw new RecordNotFoundException("The record is already exist");
    	}else { 
        repository.save(entity);
        return entity;
    	}
    } 
    
    public PlantsEntity updatePlants(PlantsEntity entity) throws RecordNotFoundException 
    {
        Optional<PlantsEntity> plant = repository.findById(entity.getId());
         PlantsEntity newEntity = plant.get();
            
         	newEntity.setFamily(entity.getFamily());
            newEntity.setcName(entity.getcName());
            newEntity.setsName(entity.getsName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
    } 
     
    public void deletePlantById(int id) throws RecordNotFoundException 
    {
        Optional<PlantsEntity> plant = repository.findById(id);
         
        if(plant.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No plant record exist for given id");
        }
    } 
}