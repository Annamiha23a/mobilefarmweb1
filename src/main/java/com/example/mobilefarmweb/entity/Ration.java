package com.example.mobilefarmweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "rations")
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feed_group_id", nullable = false)
    private FeedGroup feedGroup;

    @OneToMany(mappedBy = "ration")
    private List<RationFeeds> rationFeeds;

    @Override
    public String toString(){
        return  "rationId = " + rationId + ", " +
                "geneticGroup = " + feedGroup + ", "
                +
                "rationFeeds = " + rationFeeds
                ;
    }
}
