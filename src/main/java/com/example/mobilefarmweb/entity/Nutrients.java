package com.example.mobilefarmweb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "nutrients")
public class Nutrients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nutrientsId;

    @Column(name = "feed_unit")
    private BigDecimal feedUnit;

    @Column(name = "energy_exchange")
    private BigDecimal energyExchange;

    @Column(name = "dry_matter")
    private BigDecimal dryMatter;

    @Column(name = "dry_protein")
    private BigDecimal dryProtein;

    @Column(name = "digested_protein")
    private BigDecimal digestedProtein;

    @Column(name = "raw_fat")
    private BigDecimal rawFat;

    @Column(name = "raw_fiber")
    private BigDecimal rawFiber;

    @Column(name = "starch")
    private BigDecimal starch;

    @Column(name = "sugar")
    private BigDecimal sugar;

    @Column(name = "lysine")
    private BigDecimal lysine;

    @Column(name = "methionine_and_cystitis")
    private BigDecimal methionineAndCystitis;

    @Column(name = "calcium")
    private BigDecimal calcium;

    @Column(name = "phosphorus")
    private BigDecimal phosphorus;

    @Column(name = "magnesium")
    private BigDecimal magnesium;

    @Column(name = "potassium")
    private BigDecimal potassium;

    @Column(name = "sulfur")
    private BigDecimal sulfur;

    @Column(name = "ferrum")
    private BigDecimal ferrum;

    @Column(name = "copper")
    private BigDecimal copper;

    @Column(name = "zins")
    private BigDecimal zins;

    @Column(name = "manganese")
    private BigDecimal manganese;

    @Column(name = "cobalt")
    private BigDecimal cobalt;

    @Column(name = "iodine")
    private BigDecimal iodine;

    @Column(name = "carotene")
    private BigDecimal carotene;

    @Column(name = "vitamin_e")
    private BigDecimal vitaminE;

    @Column(name = "vitamin_D")
    private BigDecimal vitaminD;

    @Column(name = "salt")
    private BigDecimal salt;
    @Override
    public String toString(){
        return "";
    }
}
