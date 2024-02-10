package tech.techharbor.Model.Exceptions;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Integer orderId) {
        super(String.format("Order with id %d does not exist.", orderId));
    }

}
