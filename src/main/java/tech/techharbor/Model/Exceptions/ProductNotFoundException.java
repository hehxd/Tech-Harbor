package tech.techharbor.Model.Exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Integer productId) {
        super(String.format("Product with id %d does not exist.", productId));
    }
}
