package com.teamyostrik.efrip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.services.ProductService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "{productid}")
    public Optional<Product> getProductById(@PathVariable("productid") String id) {
        return productService.getProduct(id);
    }

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping(path = "/delete/{productid}")
    public void deleteProduct(@PathVariable("productid") String id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "/update/{productid}")
    public void updateProduct(@PathVariable("productid") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }


}
