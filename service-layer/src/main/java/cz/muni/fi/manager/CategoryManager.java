/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager;

import cz.muni.fi.dto.CategoryDto;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.KitSetDto;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */

public interface CategoryManager {
    
    public void createCategory(CategoryDto categoryDto) throws DataAccessException;
    
    public void saveCategory(CategoryDto categoryDto) throws DataAccessException; 
    
    public void removeCategory(CategoryDto categoryDto) throws DataAccessException;
    
    public List<CategoryDto> getAll() throws DataAccessException;
    
    public CategoryDto getByID(long ID) throws DataAccessException;
    
    public void addKitToCategory(CategoryDto categoryDto, KitDto kitDto) throws DataAccessException;
    
    public void removeKitFromCategory(CategoryDto categoryDto, KitDto kitDto) throws DataAccessException;
    
    public void addKitSetToCategory(CategoryDto categoryDto, KitSetDto kitSetDto) throws DataAccessException;
    
    public void removeKitSetFromCategory(CategoryDto categoryDto, KitSetDto kitSetDto) throws DataAccessException;
}
