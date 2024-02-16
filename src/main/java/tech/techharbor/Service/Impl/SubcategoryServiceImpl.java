package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.SubcategoryModel;
import tech.techharbor.Repository.SubcategoryRepository;
import tech.techharbor.Service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public List<SubcategoryModel> listSubcategories() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Optional<SubcategoryModel> findById(Integer id) {
        return subcategoryRepository.findById(id);
    }

    @Override
    public SubcategoryModel create(String subcategoryName, Integer categoryId) {
        SubcategoryModel subcategory = new SubcategoryModel(subcategoryName, categoryId);
        return subcategoryRepository.save(subcategory);
    }

}
