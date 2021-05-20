package com.vdab.services;

import com.vdab.domain.Category;
import com.vdab.repositorie.CategoryRepository;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();

    public Category findCategoryOne() {
        return categoryRepository.findCategoryOne();
    }
}
