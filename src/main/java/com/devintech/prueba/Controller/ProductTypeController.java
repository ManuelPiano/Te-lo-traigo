package com.devintech.prueba.Controller;

import com.devintech.prueba.Entity.ProductType;
import com.devintech.prueba.Service.ProductTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/list")
    @Operation(summary = "Listar los tipos de productos")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "mostrar los tipos de productos por id")
    public ProductType getProductTypeById(@PathVariable Long id) {
        return productTypeService.getProductTypeById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Crear un nuevo tipo de producto")
    public ResponseEntity<String> createProductType(@RequestBody ProductType productType) {
        ProductType createdProductType = productTypeService.createProductType(productType);
        if (createdProductType != null) {
            return ResponseEntity.ok("Tipo de producto creado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo crear el producto");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "modificar una tipo de producto por su id")
    public ProductType updateProductType(@PathVariable Long id, @RequestBody ProductType productType) {
        return productTypeService.updateProductType(id, productType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "borrar tipo de producto por id")
    public void deleteProductType(@PathVariable Long id) {
        productTypeService.deleteProductType(id);
    }
}
