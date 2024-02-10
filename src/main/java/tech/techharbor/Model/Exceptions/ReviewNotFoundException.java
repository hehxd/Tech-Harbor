package tech.techharbor.Model.Exceptions;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(Integer reviewId) {
        super(String.format("Review with id %d does not exist.", reviewId));
    }

}
