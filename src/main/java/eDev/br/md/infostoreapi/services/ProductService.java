package eDev.br.md.infostoreapi.services;


import eDev.br.md.infostoreapi.dtos.ProductDto;
import eDev.br.md.infostoreapi.models.ProductModel;
import eDev.br.md.infostoreapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(ProductDto productDto) {

        ProductModel productModel = new ProductModel();

        productModel.setProductName(productDto.getProductName());
        productModel.setSpecification(productDto.getSpecification());
        productModel.setManufacturer(productDto.getManufacturer());
        productModel.setSupplier(productDto.getSupplier());
        productModel.setNcm(productDto.getNcm());
        productModel.setGuarantee(productDto.getGuarantee());
        productModel.setComments(productDto.getComments());
        productModel.setProductType(productDto.getProductType());
        productModel.setCostPrice(productDto.getCostPrice());
        productModel.setSalePrice(productDto.getSalePrice());

        Double profit = productDto.getSalePrice() - productDto.getCostPrice();

        productModel.setProfit(profit);

        productRepository.save(productModel);


    }
}
