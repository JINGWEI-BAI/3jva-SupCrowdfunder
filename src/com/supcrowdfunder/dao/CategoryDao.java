package com.supcrowdfunder.dao;

import java.util.List;

import com.supcrowdfunder.entity.Category;;

public interface CategoryDao {

    public Category addCategory(Category category);	
    
    public Category retrieveCategoryById(Long id);	

    public List<Category> retrieveAllCategories();
    
    public void removeCategory(Long id);
    
    public void updateCategory(Long id,String name);
}
