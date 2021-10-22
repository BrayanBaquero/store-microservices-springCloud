package learning.store.shopping.client;

import learning.store.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
//@RequestMapping(value = "/products")
public interface ProductClient {
    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable ("id") Long id);

    @PutMapping(value = "/products/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity", required = true) Double quantity);
}
