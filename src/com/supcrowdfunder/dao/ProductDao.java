package com.supcrowdfunder.dao;

import java.util.List;

import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;

public interface ProductDao {

    public Product addProduct(Product product);	
    
    public Product retrieveProductById(Long id);	

    public List<Product> retrieveAllProducts();
    
    public void removeProduct(Long id);
	
    public List<Product> retrieveProductsUnder(float price);
    
    public void updateProduct(Long id,String name,String content,Float completion, Category category);

    public void contribute(Long id,Float num,Float oldnum);
}
