package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.Date;
import java.util.List;

public interface PetDao {

    void create(String name, int species, int sex, Date birthDate, String[] personality, boolean isFixed, boolean hasVaccinations, int size, int userId);

    Pet getPetById(int petId);

    List<Pet> listAllPets();



}
