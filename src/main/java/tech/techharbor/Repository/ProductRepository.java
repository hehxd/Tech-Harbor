package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ProductModel;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    List<ProductModel> findAllByProductIdIn (List<Integer> productIds);

    List<ProductModel> findAllByProductNameLike(String name);
}
