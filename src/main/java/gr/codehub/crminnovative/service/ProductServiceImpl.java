package gr.codehub.crminnovative.service;

import gr.codehub.crminnovative.exception.ProductCreationException;
import gr.codehub.crminnovative.exception.ProductNotFoundException;
import gr.codehub.crminnovative.model.Product;
import gr.codehub.crminnovative.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //TODO
    //check the paging method
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProducts(String productName,
                                     String lessThanPrice,
                                     String lessThanQuantity,
                                     String moreThanQuantity) throws ProductNotFoundException {


        if (productName != null)
            return productRepository.findByName(productName);
        if (lessThanPrice != null)
            return productRepository.findByPriceLessThan(
                    Double.parseDouble(lessThanPrice));
        if (moreThanQuantity != null)
            return productRepository.findByInventoryQuantityGreaterThan(
                    Integer.parseInt(moreThanQuantity));

        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductCreationException {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, int productId) throws ProductNotFoundException {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(int productIndex) {
        productRepository.deleteById(productIndex);
        return true;
    }

    @Override
    public Product getProduct(int productId) throws ProductNotFoundException {
        return null;
    }
}
