package com.example.springHibernate.controllers;

import com.example.springHibernate.models.Location;
import com.example.springHibernate.models.User;
import com.example.springHibernate.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocationById(@PathVariable Integer id) {
        return locationService.findById(id);
    }

    @GetMapping("location/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Integer id){
        Optional<Location> location = locationService.findById(id);

        if(location.isPresent()){
            Location newLocation =  location.get();
            return newLocation.getUsers();
        }
        return null;
    }

}
