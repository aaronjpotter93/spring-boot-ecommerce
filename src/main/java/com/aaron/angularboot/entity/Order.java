package com.aaron.angularboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
@Setter
// Receipt
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="total_quantity")
    private int totalQuantity;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    @Column(name="status")
    private String status;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    // this is an inverse bidirectional parameter meaning that the other table owns the relationship and the other table must specify a joincolum
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();
//    private Set<ReceiptItem> receiptItems = new HashSet<>();

    @ManyToOne
    //    Yes, the entity with the @JoinColumn annotation owns the relationship
//    and manages the foreign key in the database.
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    //    Yes, the entity with the @JoinColumn annotation owns the relationship
//    and manages the foreign key in the database.
    @JoinColumn(name="shipping_address_id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
//    Yes, the entity with the @JoinColumn annotation owns the relationship
//    and manages the foreign key in the database.
    @JoinColumn(name="billing_address_id")
    private Address billingAddress;



    public void add(OrderItem item) {

        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
