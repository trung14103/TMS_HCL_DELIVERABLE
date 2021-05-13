package com.hcl.tms_ver2.persistent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_product")
@Data
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @Id
    private int id;

    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "supply_id", insertable = false, updatable = false)
    private Integer supplyId;

    @JsonIgnore
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "supply_id")
    private Supply supply;

    @JsonIgnore
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductImage> productImageList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductEntity> productEntityList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Rate> rateList = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_date")
    private Date createdDate;
}
