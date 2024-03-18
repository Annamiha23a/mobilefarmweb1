package com.example.mobilefarmweb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "feed_groups")
public class FeedGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_group_id")
    private Long feedGroupId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "productivity")
    private BigDecimal productivity;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "genetic_weight")
    private BigDecimal geneticWeight;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrients_rate_id")
    private Nutrients nutrients;

    @OneToMany(mappedBy = "feedGroup", fetch = FetchType.LAZY)
    private List<Ration> rations;

    @OneToMany(mappedBy = "feedGroup", fetch = FetchType.LAZY)
    private List<AnimalPassport> animalPassports;

    @Override
    public String toString(){
        return  "feedGroupId = " + feedGroupId + ", " +
                "type = " + type + ", " +
                "productivity = " + productivity + ", " +
                "weight = " + weight + ", " +
                "geneticWeight = " + geneticWeight + ", " +
                "age = " + age + ", "
               + "rations = " + (Objects.isNull(rations) ? 0 : rations.size())
                ;
    }
}
