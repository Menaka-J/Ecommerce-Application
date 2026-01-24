package com.menaka.ecart.service;

import com.menaka.ecart.dto.ProductDto;
import com.menaka.ecart.dto.ProductReviewDto;
import com.menaka.ecart.entity.Product;
import com.menaka.ecart.entity.ProductReview;
import com.menaka.ecart.repository.ProductRepository;
import com.menaka.ecart.repository.ProductReviewRepository;
import com.menaka.ecart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    //getting all products
    //return only selected no.of items
    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        List<ProductDto> productDtos = products.stream().map(this::convertToDto).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
//        response.put("products", products.getContent());
        response.put("products", productDtos);
        response.put("totalProducts", products.getTotalElements());
        return response;
    }

    public ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setRatings(product.getRatings());
        dto.setCategory(product.getCategory());
        dto.setSeller(product.getSeller());
        dto.setStock(product.getStock());
        dto.setNumOfReviews(product.getNumOfReviews());

//        dto.setReviews(product.getReviews());
        List<ProductReviewDto> reviewDtos = product.getReviews().stream().map(review -> {
            ProductReview reviewDto = new ProductReview();
            reviewDto.setProductId(review.getId());
            reviewDto.setComment(review.getComment());
            reviewDto.setRating(review.getRating());
            return reviewDto;
        }).collect(Collectors.toList());
        dto.setReviews(reviewDtos);

        return dto;
    }

    //for getting product by id
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found exception" + id));
    }

    //FOR SEARCHING PRODUCTS
    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String Keyword, Double ratings) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category)) //by category
                .and(ProductSpecification.priceBetween(minPrice, maxPrice)) //by price
                .and(ProductSpecification.haNameorDescriptionLike(Keyword)) //by keyword
                .and(ProductSpecification.ratingGreaterThan(ratings));
        return productRepository.findAll(spec);
    }


    //FOR ADDING REVIEWS
    public void addReview(ProductReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductReview review = new ProductReview();
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setProduct(product);
        productReviewRepository.save(review);
    }
}
