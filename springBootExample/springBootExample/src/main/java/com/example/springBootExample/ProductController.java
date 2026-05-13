package com.example.springBootExample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro")
@RequiredArgsConstructor
public class ProductController {
    final ProductService service;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        Product product1 = service.addProduct(product);
        return product1;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Integer id){
        return service.getProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProduct();
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestParam Integer id, Integer price){
        return service.updateproduct(id,price);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteproduct(@PathVariable Integer id){
        return service.deleteproduct(id);
    }
}
