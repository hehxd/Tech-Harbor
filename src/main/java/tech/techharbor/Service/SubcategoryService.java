package tech.techharbor.Service;

import tech.techharbor.Model.SubcategoryModel;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    List<SubcategoryModel> listSubcategories();
    Optional<SubcategoryModel> findById(Integer id);

    SubcategoryModel create(String subcategoryName, Integer categoryId);
    SubcategoryModel findBySubcategoryNameLike(String subcategoryName);


}
