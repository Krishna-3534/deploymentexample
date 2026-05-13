package com.example.springBootExample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public Product addProduct(Product product){
        Product product1 = repo.save(product);
        return product1;
    }
    public Product getProduct(Integer id){
        return repo.getById(id);
       // return repo.findById(id);
    }
    public List<Product> getAllProduct(){
        return repo.findAll();
    }
    public Product updateproduct(Integer id, Integer price){
        Product product = repo.findById(id).orElseThrow();
        product.setPrice(price);
        return repo.save(product);
    }
    public String deleteproduct(Integer id){
        repo.delete(repo.findById(id).orElseThrow());
        return "Product deleted successfully";
    }
}
