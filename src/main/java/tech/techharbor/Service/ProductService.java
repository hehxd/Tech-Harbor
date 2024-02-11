package tech.techharbor.Service;


import tech.techharbor.Model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> listProducts();
    ProductModel findById(Integer id);

    ProductModel create(String name,String description, Integer warranty, Integer price);

    ProductModel update(Integer id, String name,String description, Integer warranty, Integer price);

    void delete(Integer id);

    List<ProductModel> findAllProductsWithIds (List<Integer> productIds);

    List<ProductModel> findAllByNameLike(String name);

    List<ProductModel> findAll();
}
