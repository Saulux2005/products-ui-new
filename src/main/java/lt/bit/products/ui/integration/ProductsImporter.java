package lt.bit.products.ui.integration;

import lt.bit.products.ui.service.domain.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductsImporter {

    private final static Logger LOG = LoggerFactory.getLogger(ProductsImporter.class);

    private final ProductStoreClient client;

    private final ProductRepository repository;

    public ProductsImporter(ProductStoreClient client, ProductRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 30000L)
    void importProducts() {

    }

    boolean newProductsFound() {
        Long productsInStore = client.getProductsCount();
        Long ourProducts = repository.count();
        return productsInStore < ourProducts;
    }

}

