package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.Farm;
import com.example.mobilefarmweb.entity.Organization;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface FarmService {
    Farm getFarmByGLN(String gln);
    Farm getFarmByFarmId(Long farmId);
    List<Farm> getFarmsByOrganizationId(Long organizationId);
    Farm createFarm(Farm farm, Organization organization);
//    Farm updateFarmById(Farm farm, String gln, Long organizationId, Long ownerId);
//
//    void deleteFarmById(Long farmId);
    List<Farm> getFarmByName(List<Farm> farms, String name);
    List<Farm> getFarmsByOrganizationIdAndName(Long organizationId, String name);
    Farm setFarm(Farm farm, String gln, String name, String ownerLastName, String ownerFirstName, String ownerMiddleName, String locationLocationIndex, String locationRegion, String locationDistrict, String locationLocationName, String locationCoordinates, String locationHouseNumber, String locationCorpusNumber, String locationFlatNumber, String locationPhoneNumber, String locationFaxNumber, String locationEmail, String locationStreetName);

    Integer getSize(Farm farm);
}
