package be.dungeonEcalora.rolePlayGameManagement.bll.services.product.ProductServiceImpls;
import be.dungeonEcalora.rolePlayGameManagement.bll.services.product.ProductService;
import be.dungeonEcalora.rolePlayGameManagement.dal.repositories.ProductRepository;
import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpls implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        if (p.getTitle() == null || p.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Product title cannot be empty");
        }
        try {
            return productRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }

    @Override
    public Product editProduct(Product p)  throws RuntimeException {

        if (p.getId_product() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        if (p.getTitle() == null || p.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Product title cannot be empty");
        }
        try {
            return productRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }
    @Override
    public void deleteProduct(Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);

        product.ifPresent(p -> {
            productRepository.delete(p);
            log.info("Product with id " + idProduct + " has been deleted");
        });

    }
    @Override
    public List<Product> retrieveAll() {
        return productRepository.findAll();
    }

}