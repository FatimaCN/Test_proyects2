package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Plant;
import com.example.demo.repository.PlantRepository;

import domain.PlantRequest;
 
@Service
public class PlantService {
     
    @Autowired
    PlantRepository repository;
   
     
    public List<Plant> getAllPlants()
    {
        List<Plant> plantsList = repository.findAll();
         
        if(plantsList.size() > 0) {
            return plantsList;
        } else {
            return new ArrayList<Plant>();
        }
    }
     
    public Plant getPlantById(int id) throws RecordNotFoundException 
    {
        Optional<Plant> plant = repository.findById(id);
         
        if(plant.isPresent()) {
            return plant.get();
        } else {
            throw new RecordNotFoundException("No plant record exist for given id");
        }
    }
     
    public Plant createPlants(PlantRequest entity) throws RecordNotFoundException
    {
    	
    	Optional<String> sName = Optional.of(entity.getcName());
    	Optional<String> family = Optional.of(entity.getFamily());
    	if(family.isPresent() && sName.isPresent()) {
    		Plant newEntity =new Plant();
    		newEntity.setcName(entity.getcName());
    		newEntity.setsName(entity.getsName());
    		newEntity.setFamily(entity.getFamily());
    	
    	repository.save(newEntity);
        return newEntity;
        }else {
        	throw new RecordNotFoundException("common name and scientific name are missing");
        }
    } 
    
    public Plant updatePlants(Plant entity) throws RecordNotFoundException 
    {
    	Optional<String> sName = Optional.of(entity.getcName());
    	Optional<String> family = Optional.of(entity.getFamily());
    	Optional<Plant> plant = repository.findById(entity.getId());
    	if(plant.isPresent()) {
    		if(sName.isPresent() && family.isPresent()) {
    			 Plant newEntity = plant.get();
    	            
    	         	newEntity.setFamily(entity.getFamily());
    	            newEntity.setcName(entity.getcName());
    	            newEntity.setsName(entity.getsName());
    	            
    	            newEntity = repository.save(newEntity);
    	            return newEntity;
    		}else throw new RecordNotFoundException("common name and scientific name are missing");
    			
        }else throw new RecordNotFoundException("No plant record exist for given id");
    } 
     
    public void deletePlantById(int id) throws RecordNotFoundException 
    {
        Optional<Plant> plant = repository.findById(id);
         
        if(plant.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No plant record exist for given id");
        }
    } 
}