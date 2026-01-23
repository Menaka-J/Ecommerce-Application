package com.menaka.ecart.seed;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//for inserting demo data
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    //Runs first when we start application[so data will be stored in database]
    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0) {
            List<Product> demoProducts = List.of(
                    new Product(null, "MacBook Air M3", 1099.00, "Lightweight powerhouse laptop", 4.8, "Apple Store", 10),
                    new Product(null, "Sony WH-1000XM5", 348.00, "Noise cancelling headphones", 4.5, "Best Buy", 25),
                    new Product(null, "Samsung Galaxy Watch 6", 299.99, "Smartwatch with health tracking", 4.6, "Samsung", 15),
                    new Product(null, "Keychron K2 Pro", 89.00, "Wireless mechanical keyboard", 4.7, "Keychron", 50),
                    new Product(null, "Dell UltraSharp Monitor", 579.50, "4K USB-C Hub Monitor", 4.4, "Dell", 8)
            );

            productRepository.save(demoProducts);
            System.out.println("Seeded demo products");
        }
    }
}
