package com.hcl.tms_ver2.persistent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "dbo_product_image")
@Data
public class ProductImage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_image_id")
    @Id
    private int id;

    @Column(name = "product_id", insertable=false, updatable = false)
    private int productId;

    @JsonIgnore
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "link")
    private String link;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "title")
    private String title;
}
