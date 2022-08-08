package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetAlreadyExistsException;
import com.techelevator.model.PetNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PetController {
    private PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }


    @RequestMapping(path = "/user/{user_id}/register", method = RequestMethod.POST)
    public void registerPet(@Valid @RequestBody Pet newPet, @PathVariable int user_id) {
        try {
            petDao.create(newPet.getName(), newPet.getSpecies(), newPet.getSex(), newPet.getBirthDate(), newPet.getPersonality(), newPet.isFixed(), newPet.isHasVaccinations(), newPet.getSize(), user_id);
        } catch (PetAlreadyExistsException e) {

        }

    }

    @RequestMapping(path = "/pet/{pet_id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int pet_id) {
        Pet newPet = new Pet();
        try {
            newPet = petDao.getPetById(pet_id);
        } catch (PetNotFoundException e) {

        }
        return newPet;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public List<Pet> petList() {
        return petDao.listAllPets();
    }
}