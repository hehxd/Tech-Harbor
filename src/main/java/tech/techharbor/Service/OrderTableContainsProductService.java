package tech.techharbor.Service;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.OrderTableContainsProductModel;

import java.util.List;

@Service
public interface OrderTableContainsProductService{

    List<OrderTableContainsProductModel> listAll();
}
