package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Location;
import com.example.mobilefarmweb.repository.LocationRepository;
import com.example.mobilefarmweb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    @Autowired
    public void LocationServiceImpl (LocationRepository locationRepository){
        this.locationRepository =locationRepository;
    }
    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(Long locationId) {
        Location location=locationRepository.findByLocationId(locationId).orElseThrow(()->new NoSuchElementException());
        locationRepository.delete(location);
    }
}
