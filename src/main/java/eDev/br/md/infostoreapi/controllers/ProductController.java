package eDev.br.md.infostoreapi.controllers;

import eDev.br.md.infostoreapi.dtos.ProductDto;
import eDev.br.md.infostoreapi.models.ProductModel;
import eDev.br.md.infostoreapi.repository.ProductRepository;
import eDev.br.md.infostoreapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listProducts")
    private List<ProductModel> findAll(){
        return productRepository.findAll();
    }


    @PostMapping("/createProduct")
    private void save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
}
