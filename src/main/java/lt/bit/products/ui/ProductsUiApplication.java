package lt.bit.products.ui;

import lt.bit.products.ui.integration.ProductStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductsUiApplication {

  private final ProductStoreClient storeClient;

  public ProductsUiApplication(ProductStoreClient storeClient) {
    this.storeClient = storeClient;
    storeClient.getProductsCount();
  }

  public static void main(String[] args) {
    SpringApplication.run(ProductsUiApplication.class, args);
  }

}
