package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.CategoryModel;
import tech.techharbor.Model.Exceptions.CategoryNotFoundException;
import tech.techharbor.Repository.CategoryRepository;
import tech.techharbor.Service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> listCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryModel findById(Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public CategoryModel create(String name) {
        CategoryModel category = new CategoryModel(name);
        return this.categoryRepository.save(category);
    }

    @Override
    public CategoryModel update(Integer id, String name) {
        CategoryModel category = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        category.setCategoryName(name);
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public CategoryModel categoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }


}
