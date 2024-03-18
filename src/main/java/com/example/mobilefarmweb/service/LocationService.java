package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Location;

public interface LocationService {
    Location createLocation(Location location);
    void deleteLocationById(Long locationId);
}
