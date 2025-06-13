package com.nasser.springecom.controller;

import com.nasser.springecom.model.Product;
import com.nasser.springecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product =  productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productService.addProduct(product,imageFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable int id) {
        Optional<Product> product =  productService.getProductById(id);
        return product.map(value -> ResponseEntity.ok(value.getImageData())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {

        Product updatedProduct = null;
        try {
            updatedProduct = productService.updateProduct(product,imageFile);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct.getImageName());
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product deletedProduct = productService.getProductById(id).orElseGet(null);
        if (deletedProduct != null) {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> getProducts(@RequestParam String keyword) {
        List<Product> products = productService.getProducts(keyword);
        return ResponseEntity.ok(products);
    }


}
