package com.example.angularschool.service;


import com.example.angularschool.dao.CategoryDao;
import com.example.angularschool.ds.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional
    public Category saveCategory(Category category){
        return categoryDao.save(category);
    }

    @Transactional
    public Category findCategory(int id){
        return categoryDao.findById(id)
                .orElseThrow(()->new EntityNotFoundException(
                        String.format("%s not found ::",id)
                ));
    }
    @Transactional
    public List<Category> findAllCategory(){
        return categoryDao.findAll();
    }
}
