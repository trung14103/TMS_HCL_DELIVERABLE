package com.hcl.tms_ver2.persistent.domain;

import com.hcl.tms_ver2.persistent.domain.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_supply")
@Data
public class Supply {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id")
    @Id
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supply")
    private List<Product> listProducts = new ArrayList<>();
}
