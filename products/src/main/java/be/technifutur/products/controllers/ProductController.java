package be.technifutur.products.controllers;

import be.technifutur.products.metier.service.ProductService;
import be.technifutur.products.models.dto.ProductDTO;
import be.technifutur.products.models.form.ProductForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductByID (@PathVariable Long id){
        return ResponseEntity.ok(service.getProductByID(id));
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return  ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductForm form){
        return ResponseEntity.ok(service.addProduct(form));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ProductDTO> updateProductByID(@PathVariable Long id, @RequestBody ProductForm form){
        return ResponseEntity.ok(service.updateProductByID(id,form));
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<ProductDTO> deleteProductByID(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteProductByID(id));
    }

}
