package com.retail.ecommerce_challenge.checkout;

import java.util.List;

public class CheckoutRequest {
    private List<Long> productIds;
    private String paymentMethod;
    private String deliveryWindow; 

    public List<Long> getProductIds() { return productIds; }
    public void setProductIds(List<Long> productIds) { this.productIds = productIds; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getDeliveryWindow() { return deliveryWindow; }
    public void setDeliveryWindow(String deliveryWindow) { this.deliveryWindow = deliveryWindow; }
}