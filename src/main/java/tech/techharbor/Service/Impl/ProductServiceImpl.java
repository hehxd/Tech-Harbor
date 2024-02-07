package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.Exceptions.ProductNotFoundException;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Repository.ProductRepository;
import tech.techharbor.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> listProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductModel findById(Integer id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductModel create(String name, String description, Integer price, Integer warranty) {
        ProductModel product = new ProductModel(name,description,warranty,price);
        return this.productRepository.save(product);
    }

    @Override
    public ProductModel update(Integer id, String name, String description, Integer warranty, Integer price) {
        ProductModel product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setProductName(name);
        product.setProductDescription(description);
        product.setProductWarranty(warranty);
        product.setProductPrice(price);
        return this.productRepository.save(product);
    }


    @Override
    public void delete(Integer id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<ProductModel> findAllProductsWithIds (List<Integer> productIds) {
        return this.productRepository.findAllByProductIdIn(productIds);
    }
}
