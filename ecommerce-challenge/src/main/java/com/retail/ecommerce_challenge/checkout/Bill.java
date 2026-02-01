package com.retail.ecommerce_challenge.checkout;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private Double subtotal;
    private Double discountAmount;
    private Double shippingCost;
    private Double total;
    private List<String> discountDetails = new ArrayList<>();

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<String> getDiscountDetails() {
        return discountDetails;
    }

    public void addDetail(String detail) {
        this.discountDetails.add(detail);
    }
}