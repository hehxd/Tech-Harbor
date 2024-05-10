package tech.techharbor.Service;


import tech.techharbor.Model.DeliveryModel;

import java.util.List;

public interface DeliveryService {

    List<DeliveryModel> listDeliveries();

    DeliveryModel findById(Integer id);

    DeliveryModel create(String deliveryStatus, String deliveryAddress, Integer deliveryManId, Integer orderId);

    DeliveryModel update(Integer id, String deliveryStatus, String deliveryAddress, Integer deliveryManId, Integer orderId);

    List<DeliveryModel> findByDeliveryManId(Integer deliveryManId);

    void updateDeliveryStatus(Integer deliveryId, String newStatus);

}
