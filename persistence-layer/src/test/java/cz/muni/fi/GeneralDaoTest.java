package cz.muni.fi;

import cz.muni.fi.dao.CategoryDao;
import cz.muni.fi.entity.Category;
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

/**
 *
 * @author Ondrej
 * 
 * tests add/update/remove
 * 
 */
@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-test-config.xml" })
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GeneralDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CategoryDao categoryDao;

    @PersistenceUnit
    public EntityManagerFactory emf;

    @BeforeMethod
    public void setup() {

        // fill database using DAOs               
        categoryDao.add(new Category("First category", ""));
        categoryDao.add(new Category("Second category", ""));
        categoryDao.add(new Category("Third category", ""));
    }

    @Test
    public void findCategories() {
        EntityManager em = emf.createEntityManager();
        List<Category> categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        em.close();

        Assert.assertEquals(categories.size(), 3);
        Assert.assertEquals(categories.get(0).getName(), "First category");
        Assert.assertEquals(categories.get(1).getName(), "Second category");
        Assert.assertEquals(categories.get(2).getName(), "Third category");
    }
    
    @Test
    public void removeCategories() {
        EntityManager em = emf.createEntityManager();
        List<Category> categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        em.close();
        
        categoryDao.remove(categories.get(0));
        categoryDao.remove(categories.get(1));
        categoryDao.remove(categories.get(2));
        
        em = emf.createEntityManager();
        categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        em.close();

        Assert.assertEquals(categories.size(), 0);       
    }

}
