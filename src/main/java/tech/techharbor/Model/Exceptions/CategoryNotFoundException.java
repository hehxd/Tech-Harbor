package tech.techharbor.Model.Exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Integer categoryId) {
        super(String.format("Category with id %d does not exist.", categoryId));
    }

}
