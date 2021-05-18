package com.vdab.sevices;

import domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.CategoryService;

public class CategoryServiceTest {    private CategoryService categoryService= new CategoryService();
    @Test
    public void testThatFindCategory(){
        Category foundCategory = categoryService.findCategoryOne();
        Assertions.assertEquals("combination", foundCategory.getCategoryName());
        Assertions.assertEquals(1, foundCategory.getId());

    }
}
