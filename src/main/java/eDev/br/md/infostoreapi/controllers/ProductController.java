package eDev.br.md.infostoreapi.controllers;

import eDev.br.md.infostoreapi.dtos.ProductDto;
import eDev.br.md.infostoreapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/createProduct")
    private void save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
}
