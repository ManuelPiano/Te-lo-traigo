package com.devintech.prueba.Service;

import com.devintech.prueba.Entity.Client;
import com.devintech.prueba.Entity.Product;
import com.devintech.prueba.Entity.ProductType;
import com.devintech.prueba.Entity.Quotation;
import com.devintech.prueba.Repository.ClientRepository;
import com.devintech.prueba.Repository.ProductTypeRepository;
import com.devintech.prueba.Repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductService productService;
    public Quotation generateQuotation(Client client, Product product) {
        ProductType productType = productTypeRepository.findById(product.getProductType().getId()).orElse(null);

        if (productType != null) {
            double productCost = product.getPrice();

            // Calculate costs based on percentages from the matrix
            double shippingCost = product.getPrice() * productType.getShippingPercentage();
            double importFeesCost = productCost * productType.getImportFeesPercentage();
            double insuranceCost = productCost * productType.getInsurancePercentage();
            double taxesCost = productCost * productType.getTaxesPercentage();

            double totalImportCost = shippingCost + importFeesCost + insuranceCost + taxesCost;
            double totalProductAndImportCost = productCost + totalImportCost;

            Quotation quotation = new Quotation();
            quotation.setClient(client);
            quotation.setProduct(product);
            quotation.setShippingCost(shippingCost);
            quotation.setImportFeesCost(importFeesCost);
            quotation.setInsuranceCost(insuranceCost);
            quotation.setTaxesCost(taxesCost);
            quotation.setTotalImportCost(totalImportCost);
            quotation.setTotalProductAndImportCost(totalProductAndImportCost);

            return quotationRepository.save(quotation);
        }

        return null;
    }

    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    public Quotation getQuotationById(Long quotationId) {
        return quotationRepository.findById(quotationId).orElse(null);
    }

    public void deleteQuotation(Long quotationId) {
        quotationRepository.deleteById(quotationId);
    }

}
