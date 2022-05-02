package be.technifutur.stocks.controller;

import be.technifutur.stocks.business.service.specification.ProductService;
import be.technifutur.stocks.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/stocks")
public class ProductController {

    private final ProductService service;

    // POST - http://localhost:8080/stocks/add?reference&quantity
    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addStockToProduct(@RequestParam UUID reference, @RequestParam int quantity) {
        return ResponseEntity.ok(this.service.addStockToProduct(reference, quantity));
    }

    // GET - http://localhost:8080/stocks
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return this.service.getAllProducts();
    }

    // GET - http://localhost:8080/stocks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductByStockId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getProductByStockId(id));
    }

    // GET - http://localhost:8080/stocks/product?{ref}
    @GetMapping("/product")
    public ResponseEntity<ProductDTO> getProductByRef(@RequestParam(name = "ref") UUID ref) {
        return ResponseEntity.ok(this.service.getProductByRef(ref));
    }

}
