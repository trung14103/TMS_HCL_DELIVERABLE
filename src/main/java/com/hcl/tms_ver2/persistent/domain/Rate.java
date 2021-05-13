package com.hcl.tms_ver2.persistent.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_rate")
@Data
public class Rate {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rate_id")
    @Id
    private int id;

    @Column(name = "star")
    private int star;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Rate rate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rate")
    private List<Rate> rateList = new ArrayList<>();
}
