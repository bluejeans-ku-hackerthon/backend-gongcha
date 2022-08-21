package com.bluejeans.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Insurance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private Long id;

    private int judge;
    private String comment;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL) // @OneToMany(mappedBy = "member") : 읽기전용
    private List<Video> orders = new ArrayList<>();


//    == 생성 메서드==//
    public static Insurance createInsurance(Long id, int justice, String comment) {
        Insurance insurance = new Insurance();
        insurance.setId(id);
        insurance.setJudge(justice);
        insurance.setComment(comment);

        return insurance;
    }
}
