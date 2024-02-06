package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.EmbeddedClasses.ProductIsInStockInWarehouseClass;
import tech.techharbor.Model.ProductIsInStockInWarehouseModel;

public interface ProductIsInStockInWarehouseRepository extends JpaRepository<ProductIsInStockInWarehouseModel, ProductIsInStockInWarehouseClass> {
}
