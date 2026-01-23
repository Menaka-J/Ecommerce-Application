package com.menaka.ecart.spec;

import com.menaka.ecart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    //for seraching product by category
    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) ->
                category == null ? null : cb.equal(root.get("category"), category);
    }

    //for searching by price(min,max)
    public static Specification<Product> priceBetween(Double min, Double max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min == null) return cb.lessThanOrEqualTo(root.get("price"), max);
            if (max == null) return cb.greaterThanOrEqualTo(root.get("price"), min);
            return cb.between(root.get("price"), min, max);
        };
    }

    //for searching by keyword
    public static Specification<Product> haNameorDescriptionLike(String Keyword) {

    }

}
