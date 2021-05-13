package com.hcl.tms_ver2.persistent.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_promotion")
@Data
public class Promotion {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promotion_id")
    @Id
    private int id;

    @Column(name = "name")
    private  String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "discount")
    private double discount;
}
