/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao;

import cz.muni.fi.entity.Category;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;

/**
 *
 * @author srogy
 */
public interface CategoryDao extends GeneralDao {

    public void addKitToCategory(Category category, Kit kit);

    public void removeKitFromCategory(Category category, Kit kit);

    public void addKitSetToCategory(Category category, KitSet kitSet);

    public void removeKitSetFromCategory(Category category, KitSet kitSet);
}
