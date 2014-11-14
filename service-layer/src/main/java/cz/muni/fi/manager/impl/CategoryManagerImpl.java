package cz.muni.fi.manager.impl;

import cz.muni.fi.dao.CategoryDao;
import cz.muni.fi.dto.CategoryDto;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.KitSetDto;
import cz.muni.fi.entity.Category;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;
import cz.muni.fi.manager.CategoryManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */
@Named
@Transactional
public class CategoryManagerImpl implements CategoryManager {

    @Inject
    private Mapper mapper;

    @Inject
    private CategoryDao categoryDao;

    public void createCategory(CategoryDto categoryDto) throws DataAccessException {

        Category category = mapper.map(categoryDto, Category.class);
        categoryDao.add(category);

    }

    public void saveCategory(CategoryDto categoryDto) throws DataAccessException {

        Category category = mapper.map(categoryDto, Category.class);
        categoryDao.update(category);

    }

    
    public void removeCategory(CategoryDto categoryDto) throws DataAccessException {

        Category category = mapper.map(categoryDto, Category.class);
        categoryDao.remove(category);

    }

    @SuppressWarnings("unchecked")
	public List<CategoryDto> getAll() throws DataAccessException {
        List<CategoryDto> listDto = new ArrayList<CategoryDto>();
        List<Category> list = (List<Category>) categoryDao.getAll();

        for (Category item : list) {
            listDto.add(mapper.map(item, CategoryDto.class));
        }

        return listDto;
    }

    public CategoryDto getByID(long ID) throws DataAccessException {
        return mapper.map(categoryDao.getByID(ID), CategoryDto.class);
    }

    public void addKitToCategory(CategoryDto categoryDto, KitDto kitDto) throws DataAccessException {
        categoryDao.addKitToCategory(mapper.map(categoryDto, Category.class), mapper.map(kitDto, Kit.class));
    }

    public void removeKitFromCategory(CategoryDto categoryDto, KitDto kitDto) throws DataAccessException {
        categoryDao.removeKitFromCategory(mapper.map(categoryDto, Category.class), mapper.map(kitDto, Kit.class));
    }

    public void addKitSetToCategory(CategoryDto categoryDto, KitSetDto kitSetDto) throws DataAccessException {
        categoryDao.addKitSetToCategory(mapper.map(categoryDto, Category.class), mapper.map(kitSetDto, KitSet.class));
    }

    public void removeKitSetFromCategory(CategoryDto categoryDto, KitSetDto kitSetDto) throws DataAccessException {
        categoryDao.removeKitSetFromCategory(mapper.map(categoryDto, Category.class), mapper.map(kitSetDto, KitSet.class));
    }
}
