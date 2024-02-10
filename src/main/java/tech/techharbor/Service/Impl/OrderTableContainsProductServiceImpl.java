package tech.techharbor.Service.Impl;

import tech.techharbor.Model.EmbeddedClasses.OrderTableContainsProductClass;
import tech.techharbor.Model.OrderTableContainsProductModel;
import tech.techharbor.Repository.OrderTableContainsProductClassRepository;
import tech.techharbor.Repository.OrderTableContainsProductRepository;
import tech.techharbor.Service.OrderTableContainsProductService;

public class OrderTableContainsProductServiceImpl implements OrderTableContainsProductService {
    private final OrderTableContainsProductClassRepository orderTableContainsProductClassRepository;
    private final OrderTableContainsProductRepository orderTableContainsProductRepository;

    public OrderTableContainsProductServiceImpl(OrderTableContainsProductClassRepository orderTableContainsProductClassRepository, OrderTableContainsProductRepository orderTableContainsProductRepository) {
        this.orderTableContainsProductClassRepository = orderTableContainsProductClassRepository;
        this.orderTableContainsProductRepository = orderTableContainsProductRepository;
    }

    @Override
    public int findByEmbeddedClass(Integer orderId, Integer productId) {
        OrderTableContainsProductClass orderTableContainsProductClass = this.orderTableContainsProductClassRepository.findById(orderId,productId);
        OrderTableContainsProductModel orderTableContainsProductModel=this.orderTableContainsProductRepository.findByOrderTableContainsProductClass(orderTableContainsProductClass);
        return orderTableContainsProductModel.getQuantity();
    }
}
