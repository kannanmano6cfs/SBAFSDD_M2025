package com.learning.ex_productservice.Controller;

import com.learning.ex_productservice.Exception.ProductNotFoundException;
import com.learning.ex_productservice.Model.Product;
import com.learning.ex_productservice.Repository.prdsvcRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class prdsvcController {


    @Autowired
    private Environment environment;

    @Autowired
    private prdsvcRepository repo;

    private static final String shopsvc_API="http://localhost:8082/shopping/addshopping";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String welcome(){
        return environment.getProperty("welcome.msg");
    }

    @GetMapping("/prodcount")
    public ResponseEntity<String> getcount(){
        long count = repo.count();
        return new ResponseEntity<>("Count of product is :"+count, HttpStatus.OK);
    }

    @GetMapping("/getproduct1")
    public Product getproduct1(@RequestParam int id){
    Optional<Product> products = repo.findById(id);
    return products.orElseThrow(null);
    }

    //Excpetion Handling
    @GetMapping("/getproduct2/{id}")
    public Product getproduct2(@PathVariable int id){
        Optional<Product> products = repo.findById(id);
        return products.orElseThrow(()->new ProductNotFoundException(id));
    }

    @GetMapping("/getproduct")
    public Iterable<Product> getproduct(){
        Iterable<Product> products = repo.findAll();
        return products;
    }

    @PostMapping("/addproduct")
    public ResponseEntity<String> addproduct()
    {
        Product product = new Product();
        product.setPrd_name("Samsung_S24");
        product.setPrd_price(69000);
        product.setPrd_desc("Samsung S24 advanced mobile");
        product.setPrd_count(100);
        repo.save(product);
        return new ResponseEntity<>("New Product added successfully", HttpStatus.OK);
    }

    @PostMapping("/addproduct1")
    public ResponseEntity<String> addproduct1(@RequestBody Product product){
        repo.save(product);
        return new ResponseEntity<>("New Product added successfully", HttpStatus.OK);
    }

    @RequestMapping(path="/updateproduct/{id}", method = RequestMethod.PUT)
    //@PutMapping("/updateproduct")
    public ResponseEntity<String> updateproduct(@Valid @RequestBody Product product1, @PathVariable int id){
        Product product2=repo.findById(id).orElseThrow();
        product2.setPrd_name(product1.getPrd_name());
        product2.setPrd_price(product1.getPrd_price());
        product2.setPrd_desc(product1.getPrd_desc());
        product2.setPrd_count(product1.getPrd_count());
        repo.save(product2);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable int id){
        repo.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

//    @DeleteMapping("/deleteproductname/{name}")
//    @Transactional
//    public ResponseEntity<String> deleteproductname(@PathVariable String name){
//        repo.deleteByprd_name(name);
//        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
//    }

    @GetMapping("/getproducts")
    public ResponseEntity<Page<Product>> getproducts(Pageable pageable){
        return ResponseEntity.ok(repo.findAll(pageable));
    }
    //int attempt=0;
    @GetMapping("/chooseproduct/{id}")
    //@Retry(name="fss1", fallbackMethod = "fallback")
    @CircuitBreaker(name="fss2", fallbackMethod = "fallback")
    public ResponseEntity<String> chooseproduct(@PathVariable int id){
       // System.out.println("Product chosen for attempt to shopping: "+attempt++);
        System.out.println("Product service request sent to Shopping service");
        Optional<Product> product=repo.findById(id);
        ResponseEntity<String> response= restTemplate.postForEntity(shopsvc_API, product, String.class);
        System.out.println("Product request for shopping sent successfully");
        return response;
    }

    public ResponseEntity<String> fallback(Throwable ex){
        //attempt=0;
        System.out.println("Shopping Service unavailable");
        return new ResponseEntity<>("Shopping cart currently unavailable!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
