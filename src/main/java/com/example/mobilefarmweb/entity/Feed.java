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
@Table(name = "feeds")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @OneToMany(mappedBy = "feed")
    private List<RationFeeds> rationFeeds;

    @ManyToOne
    @JoinColumn(name = "nutrients_id")
    private Nutrients nutrients;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Override
    public String toString(){
        return  "feedId = " + feedId + ", " +
                "type = " + type + ", " +
                "name = " + name;
    }
}
