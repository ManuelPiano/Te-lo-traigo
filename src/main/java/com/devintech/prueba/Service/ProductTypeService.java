package com.devintech.prueba.Service;

import com.devintech.prueba.Entity.ProductType;
import com.devintech.prueba.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public ProductType getProductTypeById(Long productTypeId) {
        return productTypeRepository.findById(productTypeId).orElse(null);
    }
    public ProductType updateProductType(Long id, ProductType newProductType) {
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);

        if (optionalProductType.isPresent()) {
            ProductType existingProductType = optionalProductType.get();
            existingProductType.setName(newProductType.getName());
            return productTypeRepository.save(existingProductType);
        } else {
            throw new IllegalArgumentException("ProductType not found with id: " + id);
        }
    }

    public void deleteProductType(Long productTypeId) {
        productTypeRepository.deleteById(productTypeId);
    }
}
