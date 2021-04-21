package com.teamyostrik.efrip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.services.ProductService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "api/product")
public class ProductController  {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping(path ="{productid}")
    public Optional<Product> getProductById(@PathVariable ("productid") String id){
        return productService.getProduct(id);
    }
    @PostMapping
    public void addProduct(Product product) {
        productService.addProduct(product);
    }
    @DeleteMapping(path = "{productid}")
    public void deleteProduct(@PathVariable ("productid") String id ){
        productService.deleteProduct(id);
    }
    @PutMapping(path = "{productid}")
    public void updateProduct(@PathVariable ("productid") String id, Product product){
        productService.updateProduct(id, product);
    }


}
