package com.praveen.Spring_Redis;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.praveen.Spring_Redis.entity.Product;
import com.praveen.Spring_Redis.repository.ProductRepository;

@Service
public class ProductService {
	
	private static final String HASH_KEY = "product";
	
	@Autowired
    private ProductRepository productRepository;

 
    @CachePut(key ="#product.productId", value = HASH_KEY)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    
    @CachePut(key = "#productId",value = HASH_KEY)
    public Product updateProduct(UUID productId ,Product product) {
        if (productRepository.existsById(product.getProductId())) {
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with ID: " + product.getProductId());
        }
    }

   
    @CacheEvict(key = "#productId",value = HASH_KEY)
    public void deleteProductById(UUID productId) {
        productRepository.deleteById(productId);
    }

    @Cacheable(key="#productId",value = HASH_KEY)
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

  
    @Cacheable(key = "allProducts",value = HASH_KEY)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
