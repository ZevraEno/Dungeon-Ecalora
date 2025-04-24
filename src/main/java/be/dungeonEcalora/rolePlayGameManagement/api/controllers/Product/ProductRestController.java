package be.dungeonEcalora.rolePlayGameManagement.api.controllers.Product;

import be.dungeonEcalora.rolePlayGameManagement.bll.services.product.ProductService;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ProductRestController {
    private  final ProductService productService;

    // http://localhost:8080/all-products
    @GetMapping("/all-products")
    public List<Product> getProducts() {
        return productService.retrieveAll();
    }

    // http://localhost:8080/add-product
    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product p) {
        return productService.addProduct(p);
    }

    // http://localhost:8080/edit-product
    @PutMapping("/edit-product")
    public Product editProduct(@RequestBody Product p) {
        return productService.editProduct(p);
    }

    // http://localhost:8080/delet-product/id
    @DeleteMapping("/delete-product/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") Long id) {
        productService.deleteProduct(id);
    }
}