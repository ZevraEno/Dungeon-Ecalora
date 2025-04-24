package be.dungeonEcalora.rolePlayGameManagement.bll.services.product;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> retrieveAll();

    Product addProduct(Product p);

    Product editProduct(Product p);

    void deleteProduct(Long id);
}
