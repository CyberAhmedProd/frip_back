package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.Role;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.services.ProductService;
import com.teamyostrik.efrip.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    public boolean checkAdmin(User user){
        for(Role role : user.getRoles()){
            if (role.getRole().equals("Admin")){
                return true;
            }
        }
        return false;
    }
    @Autowired
    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("{user_id}")
    public List<Product> getAllByUser(@PathVariable("user_id") String user_id){
        Optional<User> user=this.userService.getUser(user_id);
        if(user.isPresent()){
            User currentuser=user.get();
            if(checkAdmin(currentuser)){
                return this.productService.getAllProducts();
            }else{
                return this.productService.getAllByUser(currentuser);
            }
        }
        return null;
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
    @GetMapping(path ="/countall")
    public int countAllProduct() {
    	return productService.countProduct();
    }
    @GetMapping(path ="/countproductuser/{id}")
    public int countProductUser(@PathVariable("id") String id) {
    	return productService.countProductPerUser(id);
    }


}
