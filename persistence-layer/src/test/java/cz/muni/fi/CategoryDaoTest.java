/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi;

import cz.muni.fi.dao.CategoryDao;
import cz.muni.fi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author srogy
 */
@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-test-config.xml" })
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryDaoTest extends AbstractTestNGSpringContextTests{
     
    @Autowired
    CategoryDao categoryDao;
    
    
    @BeforeMethod
    public void setup(){
        
        Category cat = new Category("smolko","smolkova");
      
        categoryDao.add(cat);
    }
    
    @Test
    public void entityRemove() {
        int size = categoryDao.getAll().size();
        Assert.assertEquals(size,1);

        categoryDao.remove(categoryDao.getAll().get(0));
        
        size = categoryDao.getAll().size();
        Assert.assertEquals(size,0);
    }
    
}
