package dev.bazzi.AmazonBackend.product;

import dev.bazzi.AmazonBackend.auth.AuthenticationResponse;
import dev.bazzi.AmazonBackend.config.JwtService;
import dev.bazzi.AmazonBackend.user.User;
import dev.bazzi.AmazonBackend.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService {
@Autowired
  private final  ProductRepository productRepository;

    public List<Product> AllProduct(){

        return productRepository.findAll();
    }

    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }




    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);


    }
}
