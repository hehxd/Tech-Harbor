package tech.techharbor.Service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.techharbor.Model.DeliveryModel;
import tech.techharbor.Model.Exceptions.DeliveryNotFoundException;
import tech.techharbor.Repository.DeliveryRepository;
import tech.techharbor.Service.DeliveryService;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<DeliveryModel> listDeliveries() {
        return this.deliveryRepository.findAll();
    }

    @Override
    public DeliveryModel findById(Integer id) {
        return this.deliveryRepository.findById(id).orElseThrow(() -> new DeliveryNotFoundException(id));
    }

    @Override
    public DeliveryModel create(String deliveryStatus, String deliveryAddress, Integer deliveryManId, Integer orderId) {
        DeliveryModel delivery = new DeliveryModel(deliveryStatus, deliveryAddress, deliveryManId, orderId);
        return this.deliveryRepository.save(delivery);
    }


    @Override
    public DeliveryModel update(Integer id, String deliveryStatus, String deliveryAddress, Integer deliveryManId, Integer orderId) {
        DeliveryModel delivery = this.deliveryRepository.findById(id).orElseThrow(() -> new DeliveryNotFoundException(id));
        delivery.setDeliveryStatus(deliveryStatus);
        delivery.setDeliveryAddress(deliveryAddress);
        delivery.setDeliveryManId(deliveryManId);
        delivery.setOrderId(orderId);
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public List<DeliveryModel> findByDeliveryManId(Integer deliveryManId) {
        return this.deliveryRepository.findByDeliveryManId(deliveryManId);
    }

    @Transactional
    public void updateDeliveryStatus(Integer deliveryId, String newStatus) {
        DeliveryModel delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery != null) {
            delivery.setDeliveryStatus(newStatus);
            deliveryRepository.save(delivery);
        }
    }
}
