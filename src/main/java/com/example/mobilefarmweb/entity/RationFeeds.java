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
public class RationFeeds {
    @EmbeddedId
    private RationFeedKey id;

    @ManyToOne
    @MapsId("rationId")
    @JoinColumn(name = "ration_id")
    private Ration ration;

    @ManyToOne
    @MapsId("feedId")
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name = "amount")
    private BigDecimal amount;

    @Override
    public String toString(){
        return  "feed = " + feed + ", " +
                "amount = " + amount;
    }
}
