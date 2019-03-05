package com.lamdaschool.zoo.controller;

import com.lamdaschool.zoo.repository.AnimalRepository;
import com.lamdaschool.zoo.repository.TelephoneRepository;
import com.lamdaschool.zoo.repository.ZooRepository;
import com.lamdaschool.zoo.model.Animal;
import com.lamdaschool.zoo.model.Telephone;
import com.lamdaschool.zoo.model.Zoo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

import java.util.Optional;


@RestController
@RequestMapping(path="/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    AnimalRepository animalrepos;

    @Autowired
    TelephoneRepository phonerepos;

    @Autowired
    ZooRepository zoorepos;

    // Post endpoints

    // Post new zoo
    @ApiOperation(value = "Create a new zoo", response = Zoo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PostMapping("/zoos")
    public Zoo createZoo(@ApiParam(value = "Input for request body", required = true) @RequestBody Zoo zoo) throws URISyntaxException {
        return zoorepos.save(zoo);
    }

    // Post new phone
    @ApiOperation(value = "Create a new phone", response = Telephone.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PostMapping("/phones")
    public Telephone createPhone(@ApiParam(value = "Input for request body", required = true)@RequestBody Telephone phone) throws URISyntaxException {
        return phonerepos.save(phone);
    }

    // Post new animal
    @ApiOperation(value = "Create a new animal", response = Animal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PostMapping("/animals")
    public Animal createAnimal(@ApiParam(value = "Input for request body", required = true) @RequestBody Animal animal) throws URISyntaxException {
        return animalrepos.save(animal);
    }

    // Put endpoints


    // Update zoo by id
    @PutMapping("/zoos/{id}")
    public Zoo updateZooById(@RequestBody Zoo updatedZoo, @PathVariable long id) throws URISyntaxException {
        Optional<Zoo> newZoo = zoorepos.findById(id);
        if (newZoo.isPresent()) {
            updatedZoo.setZooid(id);
            zoorepos.save(updatedZoo);
            return updatedZoo;
        } else {
            return null;
        }
    }

    // Update phone by id
    @PutMapping("/phones/{id}")
    public Telephone updatePhoneById(@RequestBody Telephone updatedPhone, @PathVariable long id) throws URISyntaxException {
        Optional<Telephone> newPhone = phonerepos.findById(id);
        if (newPhone.isPresent()) {
            updatedPhone.setPhoneid(id);
            phonerepos.save(updatedPhone);
            return updatedPhone;
        } else {
            return null;
        }
    }

    // Update animal by id
    @PutMapping("/animals/{id}")
    public Animal updateAnimalById(@RequestBody Animal updatedAnimal, @PathVariable long id) throws URISyntaxException {
        Optional<Animal> newAnimal = animalrepos.findById(id);
        if (newAnimal.isPresent()) {
            updatedAnimal.setAnimalid(id);
            animalrepos.save(updatedAnimal);
            return updatedAnimal;
        } else {
            return null;
        }
    }

    // Delete Endpoints

    @DeleteMapping("/zoos/{id}")
    public Zoo deleteZooById(@PathVariable long id) {
        var foundZoo = zoorepos.findById(id);
        if(foundZoo.isPresent()) {
            zoorepos.deleteById(id);
            return foundZoo.get();
        } else {
            return null;
        }
    }


    @DeleteMapping("/phones/{id}")
    public Telephone deletePhoneById(@PathVariable long id) {
        var foundPhone = phonerepos.findById(id);
        if (foundPhone.isPresent()) {
            phonerepos.deleteById(id);
            return foundPhone.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimalById(@PathVariable long id) {
        var foundAnimal = animalrepos.findById(id);
        if (foundAnimal.isPresent()) {
            animalrepos.deleteById(id);
            return foundAnimal.get();
        } else {
            return null;
        }
    }



}
