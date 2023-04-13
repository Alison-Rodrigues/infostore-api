package eDev.br.md.infostoreapi.dtos;

import eDev.br.md.infostoreapi.models.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class ProductDto {

    private String productName;
    private String specification;
    private String manufacturer;
    private String supplier;
    private String ncm;
    private Integer guarantee;
    private String comments;
    private ProductType productType;
    private Double costPrice;
    private Double salePrice;
}
