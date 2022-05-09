package be.technifutur.stocks.controller;

import be.technifutur.stocks.business.service.specification.StockService;
import be.technifutur.stocks.model.dto.StockDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    // POST - http://localhost:8080/stocks/add?reference&quantity
    @PostMapping("/add")
    public ResponseEntity<StockDTO> addStockToProduct(@RequestParam UUID reference, @RequestParam int quantity) {
        return ResponseEntity.ok(this.service.addStockToProduct(reference, quantity));
    }

    // GET - http://localhost:8080/stocks
    @GetMapping
    public List<StockDTO> getAllProducts() {
        return this.service.getAllProducts();
    }

    // GET - http://localhost:8080/stocks/id
    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getProductByStockId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getProductByStockId(id));
    }

    // GET - http://localhost:8080/stocks/product?reference
    @GetMapping("/product")
    public ResponseEntity<StockDTO> getProductByRef(@RequestParam(name = "ref") UUID reference) {
        return ResponseEntity.ok(this.service.getProductByRef(reference));
    }

    // PUT - http://localhost:8080/stocks/id?quantity
    @PutMapping("/{id}")
    public ResponseEntity<StockDTO> updateProductStockByStockId(@PathVariable Long id, @RequestParam int quantity) {
        return ResponseEntity.ok(this.service.updateProductQuantityByStockId(id, quantity));
    }

}
