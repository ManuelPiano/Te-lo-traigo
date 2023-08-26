package com.devintech.prueba.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.io.Serializable;

@Getter @Setter @Entity @AllArgsConstructor @NoArgsConstructor
public class Quotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double shippingCost;
    private double importFeesCost;
    private double insuranceCost;
    private double taxesCost;

    private double totalImportCost;
    private double totalProductAndImportCost;
}
