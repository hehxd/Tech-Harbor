package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.Exceptions.OrderNotFoundException;
import tech.techharbor.Model.OrderTableModel;
import tech.techharbor.Repository.OrderTableRepository;
import tech.techharbor.Service.OrderTableService;

import java.util.Date;
import java.util.List;

@Service
public class OrderTableServiceImpl implements OrderTableService {

    private final OrderTableRepository orderTableRepository;

    public OrderTableServiceImpl(OrderTableRepository orderTableRepository) {
        this.orderTableRepository = orderTableRepository;
    }

    @Override
    public List<OrderTableModel> listOrders() {
        return this.orderTableRepository.findAll();
    }

    @Override
    public OrderTableModel findById(Integer id) {
        return this.orderTableRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public OrderTableModel create(String orderStatus, Date date, Integer customerId) {
        OrderTableModel order = new OrderTableModel(orderStatus, (java.sql.Date) date,customerId);
        return this.orderTableRepository.save(order);
    }

    @Override
    public OrderTableModel update(Integer id, String orderStatus, Date date) {
        OrderTableModel order = this.orderTableRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        order.setOrderStatus(orderStatus);
        order.setOrderDate((java.sql.Date) date);
        return this.orderTableRepository.save(order);
    }

    @Override
    public List<OrderTableModel> findByCustomerId(Integer customerId) {
        return this.orderTableRepository.findByCustomerId(customerId);
    }

    @Override
    public void delete(Integer id) {
        this.orderTableRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatus(Integer orderId, String newStatus) {
        OrderTableModel order = orderTableRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setOrderStatus(newStatus);
            orderTableRepository.save(order);
        }
    }
}
