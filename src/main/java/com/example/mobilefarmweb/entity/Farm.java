package com.example.mobilefarmweb.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @OneToMany(mappedBy = "farm")
    private List<AnimalPassport> animalPassports;

    @Column(name = "gln", nullable = false)
    private String gln;

    @Column(name = "registration_date", nullable = false)
    private OffsetDateTime registrationDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "forming_date", nullable = false)
    private OffsetDateTime formingDate;

    @Column(name = "is_formed", nullable = false)
    private Boolean isFormed;

    @Column(name = "former_name", nullable = false)
    private String formerName;
    @Override
    public String toString(){
        return "";
    }
}
