package com.menaka.ecart.spec;

import com.menaka.ecart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    //for seraching product by category
    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) ->
                category == null ? null : cb.equal(root.get("category"), category);
    }
}
