package com.retail.ecommerce_challenge.catalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String brand;
    private String category;
    
    private String imageUrl; 

    public Product() {
    }

    public Product(String name, String description, Double price, Integer stock, String brand, String category, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public Integer getStock() { return stock; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    
    public String getImageUrl() { return imageUrl; }
}