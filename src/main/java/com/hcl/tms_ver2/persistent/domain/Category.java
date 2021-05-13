package com.hcl.tms_ver2.persistent.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_category")
@Data
public class Category {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    @Id
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> listProducts = new ArrayList<>();
}
