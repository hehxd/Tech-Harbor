package tech.techharbor.Model.Exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Integer userId) {
        super(String.format("User with id %d does not exist.", userId));
    }

}
