package tech.techharbor.Service;

import tech.techharbor.Model.OrderTableModel;

import java.util.Date;
import java.util.List;

public interface OrderTableService {

    List<OrderTableModel> listOrders();
    OrderTableModel findById(Integer id);

    OrderTableModel create(String orderStatus, Date date, Integer customerId);

    OrderTableModel update(Integer id, String orderStatus, Date date);

    List<OrderTableModel> findByCustomerId(Integer customerId);
    void delete(Integer id);

    void updateOrderStatus(Integer orderId, String newStatus);

}
