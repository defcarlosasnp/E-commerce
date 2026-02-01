package com.retail.ecommerce_challenge.checkout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecommerce_challenge.catalog.model.Product;
import com.retail.ecommerce_challenge.catalog.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*")
public class CheckoutController {

    private final ProductRepository productRepository;
    // Nuestra "base de datos"
    private List<DeliverySlot> slots = new ArrayList<>();

    public CheckoutController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Al iniciar, creamos horarios para HOY y MAÑANA
    @PostConstruct
    public void initSlots() {
        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);

        slots.add(new DeliverySlot("1", hoy, "09:00 - 13:00", 3, 3990.0));
        slots.add(new DeliverySlot("2", hoy, "14:00 - 18:00", 5, 3990.0));
        slots.add(new DeliverySlot("3", hoy, "19:00 - 21:00", 0, 3990.0)); // Agotado para probar
        slots.add(new DeliverySlot("4", manana, "09:00 - 13:00", 10, 3990.0));
    }

    // calculos
    @PostMapping("/calculate")
    public Bill calculate(@RequestBody CheckoutRequest request) {
        Bill bill = new Bill();
        Double subtotal = 0.0;

        List<Product> products = productRepository.findAllById(request.getProductIds());
        for (Product p : products) {
            subtotal += p.getPrice();
        }

        Double discounts = 0.0;
        if ("DEBITO".equalsIgnoreCase(request.getPaymentMethod())) {
            discounts = subtotal * 0.10;
            bill.addDetail("Descuento Débito (10%)");
        }

        Double shipping = 0.0;
        if (request.getDeliveryWindow() != null && !request.getDeliveryWindow().isEmpty()) {

            Optional<DeliverySlot> slotOpt = slots.stream()
                    .filter(s -> s.getTimeRange().equals(request.getDeliveryWindow()))
                    .findFirst();

            if (slotOpt.isPresent()) {
                DeliverySlot slot = slotOpt.get();
                shipping = slot.getPrice();

                if (slot.getCapacity() <= 0) {
                    bill.addDetail("⚠️ HORARIO AGOTADO (" + slot.getTimeRange() + ")");
                } else {
                    bill.addDetail("Despacho: " + slot.getTimeRange());
                }
            }
        } else {
            bill.addDetail("Retiro en Tienda");
        }

        if (subtotal > 500000) {
            shipping = 0.0;
            bill.addDetail("Envío Gratis por monto");
        }

        bill.setSubtotal(subtotal);
        bill.setDiscountAmount(discounts);
        bill.setShippingCost(shipping);
        bill.setTotal((subtotal - discounts) + shipping);

        return bill;
    }
}