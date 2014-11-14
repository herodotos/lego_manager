/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi;

import static org.mockito.Mockito.verify;

import org.dozer.DozerBeanMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.dao.KitDao;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.manager.KitManager;
import cz.muni.fi.manager.impl.KitManagerImpl;

/**
 *
 * @author moon
 */

@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-service-layer-test-config.xml" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class KitManagerTest extends AbstractTestNGSpringContextTests {

	@Mock
	private KitDao kitDao;

	@Spy
	DozerBeanMapper mapper;
	
	KitDto kitDto;

	@InjectMocks
	private final KitManager kitService = new KitManagerImpl();

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		kitDto = new KitDto();
		kitDto.setAgeLimit(20);
		kitDto.setCategory(null);
		kitDto.setId(0);
		kitDto.setName("Kocka");
		kitDto.setParts(null);
		kitDto.setPrice(200);

	}

	@Test
	public void addKitTest() {

		kitService.createKit(kitDto);
		verify(kitService).createKit(kitDto);

	}

	@Test
	public void removeKitTest() {

		kitService.removeKit(kitDto);
		verify(kitService).removeKit(kitDto);

	}

	@Test
	public void saveKitTest() {

		kitService.saveKit(kitDto);
		verify(kitService).saveKit(kitDto);

	}

}
