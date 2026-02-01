package com.retail.ecommerce_challenge.checkout;

import java.time.LocalDate;

public class DeliverySlot {
    private String id;
    private LocalDate date;
    private String timeRange; // Ejemplo: "09:00 - 13:00"
    private Integer capacity; // Ejemplo: 5 cupos
    private Double price;

    public DeliverySlot(String id, LocalDate date, String timeRange, Integer capacity, Double price) {
        this.id = id;
        this.date = date;
        this.timeRange = timeRange;
        this.capacity = capacity;
        this.price = price;
    }

    // Restar un cupo si hay disponibles
    public boolean reserve() {
        if (this.capacity > 0) {
            this.capacity--;
            return true;
        }
        return false;
    }

    public String getTimeRange() { return timeRange; }
    public Integer getCapacity() { return capacity; }
    public Double getPrice() { return price; }
}