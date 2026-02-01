package com.retail.ecommerce_challenge.catalog;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.retail.ecommerce_challenge.catalog.model.Product;
import com.retail.ecommerce_challenge.catalog.repository.ProductRepository;

@Configuration
public class DataInitializer {

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.deleteAll();

            repository.saveAll(List.of(
                    new Product("Zapatillas Runner X", "Zapatillas para running, suela EVA, talle 40-45", 79990.0, 25,
                            "SportCo", "Calzado",
                            "https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=300&q=80"),
                    new Product("Camisa Casual Lona", "Camisa algodón premium, manga larga", 34500.0, 100, "ModaYa",
                            "Ropa",
                            "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?auto=format&fit=crop&w=300&q=80"),
                    new Product("Auriculares Inalámbricos A1", "Bluetooth 5.2, cancelación ruido", 59000.0, 10,
                            "SoundMax", "Electrónica",
                            "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=300&q=80"),
                    new Product("Cafetera Express 12oz", "Cafetera automática, 15 bar", 129000.0, 5, "HomeBrew",
                            "Hogar",
                            "https://images.unsplash.com/photo-1599554032085-3c94481333d7?auto=format&fit=crop&w=300&q=80"),
                    new Product("Mochila Urbana 20L", "Mochila impermeable, compartimento laptop 15\"", 49900.0, 40,
                            "UrbanPack", "Accesorios",
                            "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?auto=format&fit=crop&w=300&q=80"),
                    new Product("Pantalón Jogger", "Jogger sport con ajuste elástico", 29900.0, 60, "ModaYa", "Ropa",
                            "https://images.unsplash.com/photo-1552902865-b72c031ac5ea?auto=format&fit=crop&w=300&q=80"),
                    new Product("Smartwatch S2", "Monitor cardíaco, notificaciones", 89000.0, 15, "TimeTech",
                            "Electrónica",
                            "https://images.unsplash.com/photo-1523275335684-37898b6baf30?auto=format&fit=crop&w=300&q=80"),
                    new Product("Lámpara LED de Mesa", "Luz regulable, USB-C", 24500.0, 30, "LightIt", "Hogar",
                            "https://images.unsplash.com/photo-1507473888900-52e1adad5474?auto=format&fit=crop&w=300&q=80"),
                    new Product("Set de Cocina 3 Piezas", "Ollas antiadherentes, apto inducción", 69990.0, 8,
                            "CookWell", "Hogar",
                            "https://images.unsplash.com/photo-1584992236310-6edddc08acff?auto=format&fit=crop&w=300&q=80"),
                    new Product("Calcetines Pack x3", "Algodón confortable", 9990.0, 200, "BasicWear", "Ropa",
                            "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?auto=format&fit=crop&w=300&q=80")));

            System.out.println("--- DATOS DEL CASO (catalog.json) CARGADOS ---");
        };
    }
}