package com.nasser.springecom.service;

import com.nasser.springecom.model.Product;
import com.nasser.springecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        if (product.getCategory() != null) {
            product.setCategory(product.getCategory().substring(0, 1).toUpperCase() +
                    product.getCategory().substring(1).toLowerCase());
        }
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
        if (product.getCategory() != null) {
            product.setCategory(product.getCategory().substring(0, 1).toUpperCase() +
                    product.getCategory().substring(1).toLowerCase());
        }
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepository.save(product);

    }



    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public List<Product> getProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
