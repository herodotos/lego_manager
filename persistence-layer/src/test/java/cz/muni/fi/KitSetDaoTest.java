/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi;

import cz.muni.fi.dao.KitSetDao;
import cz.muni.fi.entity.KitSet;
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
public class KitSetDaoTest extends AbstractTestNGSpringContextTests { 
 
    
    
    
    @Autowired
    KitSetDao kitsetDao;

    @PersistenceUnit
    public EntityManagerFactory emf;

    @BeforeMethod
    public void setup() {

        // fill database using DAOs  
        kitsetDao.add(new KitSet("Fst kitset",200));
        kitsetDao.add(new KitSet("Scnd kitset",300));
        kitsetDao.add(new KitSet("Thrd kitset",400));
       
    }

    @Test
    public void findKitSet() {
        EntityManager em = emf.createEntityManager();
        List<KitSet> kitsets = em.createQuery("SELECT c FROM KitSet c", KitSet.class).getResultList();
        em.close();

        Assert.assertEquals(kitsets.size(), 3);
        Assert.assertEquals(kitsets.get(0).getName(), "Fst kitset");
        Assert.assertEquals(kitsets.get(0).getPrice(), 200);
                
        Assert.assertEquals(kitsets.get(1).getName(), "Scnd kitset");
        Assert.assertEquals(kitsets.get(1).getPrice(), 300);
                
        Assert.assertEquals(kitsets.get(2).getName(), "Thrd kitset");
       Assert.assertEquals(kitsets.get(2).getPrice(), 400);
    }
    
    
    @Test
    public void removeKitSets() {
        EntityManager em = emf.createEntityManager();
        List<KitSet> kitsets = em.createQuery("SELECT c FROM KitSet c", KitSet.class).getResultList();
        em.close();
        
        kitsetDao.remove(kitsets.get(0));
        kitsetDao.remove(kitsets.get(1));
        kitsetDao.remove(kitsets.get(2));
        
        em = emf.createEntityManager();
        kitsets = em.createQuery("SELECT c FROM KitSet c", KitSet.class).getResultList();
        em.close();

        Assert.assertEquals(kitsets.size(), 0);       
    }
        
}