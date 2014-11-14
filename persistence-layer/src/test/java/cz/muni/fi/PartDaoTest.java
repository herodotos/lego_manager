/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi;

import cz.muni.fi.dao.PartDao;
import cz.muni.fi.entity.Part;
import cz.muni.fi.entity.PartBlueprint;
import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PartDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	PartDao partDao;

	@PersistenceUnit
	public EntityManagerFactory emf;

	@BeforeMethod
	public void setup() {

		Color black = new Color(20);
		Set<Color> avaC = new HashSet<Color>();

		avaC.add(black);

		PartBlueprint pb1 = new PartBlueprint("blueP", avaC);

		// fill database using DAOs
		partDao.add(new Part(pb1, "Kocka", black));
		partDao.add(new Part(pb1, "Kocka", black));
		partDao.add(new Part(pb1, "Kocka", black));

	}

	@Test
	public void findPart() {
		EntityManager em = emf.createEntityManager();
		List<Part> parts = em.createQuery("SELECT c FROM Part c", Part.class)
				.getResultList();
		em.close();

		Assert.assertEquals(parts.size(), 3);
		Assert.assertEquals(parts.get(0).getName(), "Kocka");
		// Assert.assertEquals(parts.get(0).getPrice(), 10);
		// Assert.assertEquals(parts.get(0).getAgeLimit(), 20);

		/*
		 * Assert.assertEquals(parts.get(1).getName(), "Scnd kit");
		 * Assert.assertEquals(parts.get(1).getPrice(), 20);
		 * Assert.assertEquals(parts.get(1).getAgeLimit(), 30);
		 * 
		 * Assert.assertEquals(parts.get(2).getName(), "Thrd kit");
		 * Assert.assertEquals(parts.get(2).getPrice(), 30);
		 * Assert.assertEquals(parts.get(2).getAgeLimit(), 40);
		 */
	}

	@Test
	public void removeParts() {
		EntityManager em = emf.createEntityManager();
		List<Part> parts = em.createQuery("SELECT c FROM Part c", Part.class)
				.getResultList();
		em.close();

		partDao.remove(parts.get(0));
		partDao.remove(parts.get(1));
		partDao.remove(parts.get(2));

		em = emf.createEntityManager();
		parts = em.createQuery("SELECT c FROM Part c", Part.class)
				.getResultList();
		em.close();

		Assert.assertEquals(parts.size(), 0);
	}

}
