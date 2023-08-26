package com.devintech.prueba.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Getter @Setter @Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double shippingPercentage;
    private double importFeesPercentage;
    private double insurancePercentage;
    private double taxesPercentage;
}
