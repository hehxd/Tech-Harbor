package tech.techharbor.Service;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.OrderTableContainsProductModel;

@Service
public interface OrderTableContainsProductService{
    public int findByEmbeddedClass(Integer orderId,Integer productId);
}
