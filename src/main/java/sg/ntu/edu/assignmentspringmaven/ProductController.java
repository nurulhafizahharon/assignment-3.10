package sg.ntu.edu.assignmentspringmaven;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ArrayList<Product> products = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController() {
        products.add(new Product("Apple", "This is an apple", 1.99));
        products.add(new Product("Banana", "This is a banana", 1.99));
        products.add(new Product("Carrot", "This is a carrot", 1.99));
        logger.info("Added default products");
    }

    // CREATE PRODUCT
    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        logger.info("Created new product");
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // READ (GET ALL)
    @GetMapping("")
    public ResponseEntity<ArrayList<Product>> getAllCustomers() {
        logger.info("Displaying all products");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
