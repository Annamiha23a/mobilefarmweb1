package com.example.mobilefarmweb.entity;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "location_id", nullable = false)
//    private LocationEntity location;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "owner_id", nullable = false)
//    private OwnerEntity owner;
//
//    @OneToMany(mappedBy = "organization")
//    private List<FarmEntity> farms;

    @Column(name = "gln", nullable = false)
    private String gln;

    @Column(name = "registration_date", nullable = false)
    private OffsetDateTime registrationDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "unp", nullable = false)
    private String unp;

    @Column(name = "okpo", nullable = false)
    private String okpo;

    @Column(name = "egr", nullable = false)
    private String egr;

    @Column(name = "created_date", nullable = false)
    private OffsetDateTime createdDate;

    @Column(name = "bank_code", nullable = false)
    private String bankCode;

    @Column(name = "payment_account", nullable = false)
    private String paymentAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization")
    private List<User> users = new ArrayList<>();
}
