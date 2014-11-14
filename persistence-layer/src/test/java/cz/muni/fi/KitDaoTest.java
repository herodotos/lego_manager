package cz.muni.fi;


import cz.muni.fi.dao.KitDao;
import cz.muni.fi.entity.Kit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moon
 */


@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-test-config.xml" })
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class KitDaoTest extends AbstractTestNGSpringContextTests { 
 
    
    
    
    @Autowired
    KitDao kitDao;

    @PersistenceUnit
    public EntityManagerFactory emf;

    @BeforeMethod
    public void setup() {

        // fill database using DAOs  
        kitDao.add(new Kit("Fst kit", 10 , 20));
        kitDao.add(new Kit("Scnd kit", 20 , 30));
        kitDao.add(new Kit("Thrd kit", 30 , 40));
       
    }

    @Test
    public void findKit() {
        EntityManager em = emf.createEntityManager();
        List<Kit> kits = em.createQuery("SELECT c FROM Kit c", Kit.class).getResultList();
        em.close();

        Assert.assertEquals(kits.size(), 3);
        Assert.assertEquals(kits.get(0).getName(), "Fst kit");
        Assert.assertEquals(kits.get(0).getPrice(), 10);
        Assert.assertEquals(kits.get(0).getAgeLimit(), 20);
                
        Assert.assertEquals(kits.get(1).getName(), "Scnd kit");
        Assert.assertEquals(kits.get(1).getPrice(), 20);
        Assert.assertEquals(kits.get(1).getAgeLimit(), 30);
                
        Assert.assertEquals(kits.get(2).getName(), "Thrd kit");
        Assert.assertEquals(kits.get(2).getPrice(), 30);
        Assert.assertEquals(kits.get(2).getAgeLimit(), 40);
    }
    
    
    @Test
    public void removeKits() {
        EntityManager em = emf.createEntityManager();
        List<Kit> kits = em.createQuery("SELECT c FROM Kit c", Kit.class).getResultList();
        em.close();
        
        kitDao.remove(kits.get(0));
        kitDao.remove(kits.get(1));
        kitDao.remove(kits.get(2));
        
        em = emf.createEntityManager();
        kits = em.createQuery("SELECT c FROM Kit c", Kit.class).getResultList();
        em.close();

        Assert.assertEquals(kits.size(), 0);       
    }
    
    
    
    
    
    
    
}
