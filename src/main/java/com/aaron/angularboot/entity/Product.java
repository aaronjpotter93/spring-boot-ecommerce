package com.aaron.angularboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

//    -- Create the product table
//    CREATE TABLE product (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        category_id BIGINT NOT NULL,
//        sku VARCHAR(255),
//        name VARCHAR(255),
//        description TEXT,
//        unit_price DECIMAL(19, 2),
//        image_url VARCHAR(255),
//        active BOOLEAN,
//        units_in_stock INT,
//        date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//        last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//        FOREIGN KEY (category_id) REFERENCES product_category(id)
//    );

@Entity
@Table(name = "product") // Maps the class to the "product" table.
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // SQL: id BIGINT AUTO_INCREMENT PRIMARY KEY
    // Explanation: The primary key is auto-incremented using the database's identity mechanism.
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // SQL: FOREIGN KEY (category_id) REFERENCES product_category(id)
    // Explanation: Many `Product`s belong to one `ProductCategory`.
    // The `fetch = FetchType.LAZY` means the related `ProductCategory` is only fetched when accessed.
    @JoinColumn(name = "category_id", nullable = false)
    // SQL: category_id BIGINT NOT NULL
    // Explanation: Defines the foreign key column in the `Product` table.
    private ProductCategory category;

    @Column(name = "sku")
    // SQL: sku VARCHAR(255)
    // Explanation: Maps to the "sku" column, which can store a product SKU string.
    private String sku;

    @Column(name = "name")
    // SQL: name VARCHAR(255)
    private String name;

    @Column(name = "description")
    // SQL: description TEXT
    private String description;

    @Column(name = "unit_price")
    // SQL: unit_price DECIMAL(19, 2)
    // Explanation: A column to store the product's price with precision.
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    // SQL: image_url VARCHAR(255)
    private String imageUrl;

    @Column(name = "active")
    // SQL: active BOOLEAN
    // Explanation: Indicates if the product is active or not.
    private boolean active;

    @Column(name = "units_in_stock")
    // SQL: units_in_stock INT
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    // SQL: date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    // Explanation: Automatically sets the creation timestamp.
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    // SQL: last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    // Explanation: Automatically updates the timestamp when the entity changes.
    private Date lastUpdated;
}