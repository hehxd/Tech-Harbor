package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.EmbeddedClasses.OrderTableContainsProductClass;
import tech.techharbor.Model.OrderTableContainsProductModel;
import tech.techharbor.Repository.OrderTableContainsProductRepository;
import tech.techharbor.Service.OrderTableContainsProductService;

import java.util.List;

@Service
public class OrderTableContainsProductServiceImpl implements OrderTableContainsProductService {
    private final OrderTableContainsProductRepository orderTableContainsProductRepository;

    public OrderTableContainsProductServiceImpl(OrderTableContainsProductRepository orderTableContainsProductRepository) {
        this.orderTableContainsProductRepository = orderTableContainsProductRepository;
    }

    @Override
    public List<OrderTableContainsProductModel> listAll() {
        return this.orderTableContainsProductRepository.findAll();
    }

    @Override
    public OrderTableContainsProductModel create(Integer orderId, Integer productId, Integer quantity) {
        OrderTableContainsProductClass embededId = new OrderTableContainsProductClass(orderId, productId);
        OrderTableContainsProductModel order = new OrderTableContainsProductModel(embededId, quantity);
        return orderTableContainsProductRepository.save(order);
    }

}
