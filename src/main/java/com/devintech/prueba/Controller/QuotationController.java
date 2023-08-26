package com.devintech.prueba.Controller;

import com.devintech.prueba.Entity.Client;
import com.devintech.prueba.Entity.Product;
import com.devintech.prueba.Entity.Quotation;
import com.devintech.prueba.Service.ClientService;
import com.devintech.prueba.Service.ProductService;
import com.devintech.prueba.Service.QuotationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/quotations")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @PostMapping("/calculate")
    @Operation(summary = "Realizar una cotizacion por producto")
    public ResponseEntity<Quotation> calculateAndSaveQuotation(
            @RequestBody Map<String, Long> requestMap) {

        Long clientId = requestMap.get("clientId");
        Long productId = requestMap.get("productId");

        if (clientId != null && productId != null) {
            Client client = clientService.getClientById(clientId);
            Product product = productService.getProductById(productId).orElse(null);

            if (client != null && product != null) {
                Quotation calculatedQuotation = quotationService.generateQuotation(client, product);
                if (calculatedQuotation != null) {
                    return new ResponseEntity<>(calculatedQuotation, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }




    @GetMapping("/Quotation-list")
    @Operation(summary = "mostrar todas las cotizaciones")
    public ResponseEntity<List<Quotation>> getAllQuotations() {
        List<Quotation> quotations = quotationService.getAllQuotations();
        return new ResponseEntity<>(quotations, HttpStatus.OK);
    }

    @GetMapping("/{quotationId}")
    @Operation(summary = "mostrar cotizaciones por id")
    public ResponseEntity<Quotation> getQuotationById(@PathVariable Long quotationId) {
        Quotation quotation = quotationService.getQuotationById(quotationId);
        if (quotation != null) {
            return new ResponseEntity<>(quotation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{quotationId}")
    @Operation(summary = "borrar cotizaciones por id")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long quotationId) {
        quotationService.deleteQuotation(quotationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
