package com.aaron.angularboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="zip_code")
    private String zipCode;

    @OneToOne
    // WARNING: THIS ANNOTATION DOESN'T SCALE. CONSTRICTS USER TO ONLY BE ABLE TO ORDER ONCE WITH THEIR GIVEN ADDRESS. POOPOO DESIGN.
    @PrimaryKeyJoinColumn
    private Order order;
}
