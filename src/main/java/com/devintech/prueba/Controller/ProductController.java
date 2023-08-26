package com.devintech.prueba.Controller;

import com.devintech.prueba.Entity.Product;
import com.devintech.prueba.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @Operation(summary = "Crear nuevo Producto")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        if (createdProduct != null) {
            return ResponseEntity.ok("Producto creado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo crear el producto");
        }
    }

    @GetMapping("/product-list")
    @Operation(summary = "Listar todos los productos")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(summary = "mostar productos por ID")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "modificar productos por ID")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product updated = productService.updateProduct(id, updatedProduct);
        if (updated != null) {
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar productos por ID")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }
}
