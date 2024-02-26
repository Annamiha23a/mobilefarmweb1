package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository  extends JpaRepository<Organization, Long> {
    Organization findByGln(String gln);
    Organization findByUnp(String unp);
}
