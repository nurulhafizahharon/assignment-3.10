package sg.ntu.edu.assignmentspringmaven;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Product {

    private String id;
    private String name;
    private String description;
    private double price;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String name, String description, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
