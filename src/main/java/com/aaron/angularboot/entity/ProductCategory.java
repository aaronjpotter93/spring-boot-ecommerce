package com.aaron.angularboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
//CREATE TABLE product_category (
//    id BIGINT AUTO_INCREMENT PRIMARY KEY,
//    category_name VARCHAR(255) NOT NULL
//);

@Entity
@Table(name = "product_category") // Maps the class to the "product_category" table.
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // SQL: id BIGINT AUTO_INCREMENT PRIMARY KEY
    // Explanation: The primary key is auto-incremented using the database's identity mechanism.
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    // SQL: category_name VARCHAR(255) NOT NULL
    // Explanation: Maps the field to the "category_name" column in the table.
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    // SQL: This does not directly translate to a column but represents the
    //       relationship. JPA expects "product.category_id" to refer to this entity's "id".
    // Explanation: One `ProductCategory` can have many `Product`s.
    // The "mappedBy" attribute specifies that the "category" field in the `Product` class owns the relationship.
    private Set<Product> products;
}