package services;

import domain.Category;
import repositorie.CategoryRepository;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();

    public Category findCategoryOne() {
        return categoryRepository.findCategoryOne();
    }
}
