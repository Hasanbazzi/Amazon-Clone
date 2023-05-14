package dev.bazzi.AmazonBackend.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private int price;
    private int rating;
    private String image;

    public Product(String title, int price, int rating, String image) {
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.image = image;
    }
}
