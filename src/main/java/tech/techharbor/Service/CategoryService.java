package tech.techharbor.Service;

import tech.techharbor.Model.CategoryModel;
import java.util.List;


public interface CategoryService {
    List<CategoryModel> listCategories();
    CategoryModel findById(Integer id);

    CategoryModel create(String name);

    CategoryModel update(Integer id, String name);

    void delete(Integer id);

    CategoryModel categoryByName(String name);
}
