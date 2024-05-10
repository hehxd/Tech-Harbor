package tech.techharbor.Model.Exceptions;

public class DeliveryNotFoundException extends RuntimeException{

    public DeliveryNotFoundException(Integer deliveryId) {
        super(String.format("Delivery with id %d does not exist.", deliveryId));
    }

}
