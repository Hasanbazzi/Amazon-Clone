package dev.bazzi.AmazonBackend.product;

import dev.bazzi.AmazonBackend.auth.AuthenticationResponse;
import dev.bazzi.AmazonBackend.config.JwtService;
import dev.bazzi.AmazonBackend.user.User;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {

@Autowired
  private final ProductService productService;

    @GetMapping("/all")
    @PermitAll
    public ResponseEntity<List<Product>> GetAllProduct(){
        List<Product> product=productService.AllProduct();

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> CreateProduct( @RequestBody Product product1) {
        Product product=productService.createProduct(product1);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> CreateProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
