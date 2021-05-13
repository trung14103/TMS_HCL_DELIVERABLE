package com.hcl.tms_ver2.persistent.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_size")
public class Size {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "size_id")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size")
    private List<ProductEntity> productEntityList = new ArrayList<>();
}
