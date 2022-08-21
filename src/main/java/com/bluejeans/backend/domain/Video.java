package com.bluejeans.backend.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}
