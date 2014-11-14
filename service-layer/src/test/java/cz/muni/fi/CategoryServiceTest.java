/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.dto.CategoryDto;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.manager.CategoryManager;


/**
 *
 * @author srogy
 */
@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-service-layer-test-config.xml" })
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryServiceTest extends AbstractTestNGSpringContextTests{

    @Inject
    private CategoryManager categoryManager;
    
    
    @BeforeMethod
    public void setup(){
        
        CategoryDto catDto = new CategoryDto();
        
        catDto.setName("lolotrolo");
        Set <KitDto>kits = new HashSet<KitDto>();
        KitDto kit = new KitDto();
        kit.setName("trolololo");
        kits.add(kit);
        catDto.setKits(kits);
        System.out.println("nasrat1"); 
        categoryManager.createCategory(catDto);
    }
    
    @Test
    public void entitySave() {

    }
}
