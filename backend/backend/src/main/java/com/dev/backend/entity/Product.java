package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shortDescription;
    private String longDescription;
    private Double costValue;
    private Double sellingValue;
    @ManyToOne
    @JoinColumn(name = "idBrand")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
