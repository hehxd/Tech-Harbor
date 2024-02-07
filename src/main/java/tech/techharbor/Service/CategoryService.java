package tech.techharbor.Service;

import tech.techharbor.Model.CategoryModel;
import java.util.List;
import java.util.Optional;


public interface CategoryService {
    List<CategoryModel> listCategories();
    Optional<CategoryModel> findById(Integer id);

    CategoryModel create(String name);

    CategoryModel update(Integer id, String name);

    void delete(Integer id);

    CategoryModel categoryByName(String name);
}
