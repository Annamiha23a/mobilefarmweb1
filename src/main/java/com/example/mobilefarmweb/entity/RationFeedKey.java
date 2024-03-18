package com.example.mobilefarmweb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Data
public class RationFeedKey implements Serializable {
    @Column(name = "ration_id")
    Long rationId;

    @Column(name = "feed_id")
    Long feedId;
}
