package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Farm;

import java.util.List;

public interface FarmService {
    Farm getFarmByGLN(String gln);
    List<Farm> getFarmsByOrganizationId(Long organizationId);
//    Farm createFarm(Farm farm, Long organizationId);
//    Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId);
//
//    void deleteFarmById(Long farmId);
    List<Farm> getFarmByName(List<Farm> farms, String name);
    List<Farm> getFarmsByOrganizationIdAndName(Long organizationId, String name);
}
