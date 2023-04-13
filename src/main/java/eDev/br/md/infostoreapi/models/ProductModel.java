package eDev.br.md.infostoreapi.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "specification", length = 150)
    private String specification;

    @Column(name = "manufacturer", length = 150)
    private String manufacturer;

    @Column(name = "supplier", length = 150)
    private String supplier;

    @Column(name = "ncm", length = 20)
    private String ncm;

    @Column(name = "guarantee", length = 20)
    private Integer guarantee;

    @Column(name = "comments", length = 150)
    private String comments;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "profit")
    private Double profit;
}
