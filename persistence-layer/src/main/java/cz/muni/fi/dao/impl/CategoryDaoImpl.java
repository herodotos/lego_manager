/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.CategoryDao;
import cz.muni.fi.entity.Category;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;

import java.util.List;

import javax.inject.Named;

/**
 *
 * @author srogy
 */
@Named("categoryDao")
public class CategoryDaoImpl extends GeneralDaoImpl implements CategoryDao{

    
    public CategoryDaoImpl() {
        super();
    }
  
    @Override
    public List<Category> getAll() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Category getByID(long ID) {
        return (Category)entityManager.find(Category.class, ID);
    }

    public void addKitToCategory(Category category, Kit kit) {
        category.getKits().add(kit);
        this.update(category);
    }

    public void removeKitFromCategory(Category category, Kit kit) {
        category.getKits().remove(kit);
        this.update(category);
    }

    public void addKitSetToCategory(Category category, KitSet kitSet) {
        category.getKitSets().add(kitSet);
        this.update(category);
    }

    public void removeKitSetFromCategory(Category category, KitSet kitSet) {
        category.getKitSets().remove(kitSet);
        this.update(category);
    }
}
