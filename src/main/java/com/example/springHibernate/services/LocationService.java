package com.example.springHibernate.services;

import com.example.springHibernate.models.Location;
import com.example.springHibernate.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<com.example.springHibernate.models.Location> findAll() {
        return (List<Location>) locationRepository.findAll();
    }

    public Optional<com.example.springHibernate.models.Location> findById(Integer id) {
        return locationRepository.findById(id);
    }
}
