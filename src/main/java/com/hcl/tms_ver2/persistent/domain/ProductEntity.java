package com.hcl.tms_ver2.persistent.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity(name = "dbo_product_entity")
@Data
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_entity_id")
    @Id
    private int id;

    @Column(name = "amount")
    private long amount;

    @Column(name = "size_id", insertable = false, updatable = false)
    private int sizeId;

    @JsonIgnore
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="size_id")
    private Size size;

    @Column(name = "color_id", insertable = false, updatable = false)
    private int colorId;


    @JsonIgnore
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="color_id")
    private Color color;

    @Column(name = "product_id", insertable = false, updatable = false)
    private int productId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

}
