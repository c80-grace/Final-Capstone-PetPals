package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Place;
import com.techelevator.model.ZipCodeNotFoundException;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


public interface GeocodeDao {

        Marker getGeocodeByZip(int zipCode) throws JsonProcessingException, ZipCodeNotFoundException;

        String getGeocodeTest15217();

        ArrayList<String> getMarkerInsertsByZipArray(int[] zipsToGeocode) throws JsonProcessingException, ZipCodeNotFoundException;





}




