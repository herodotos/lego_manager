/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager.impl;

import cz.muni.fi.dao.KitDao;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.PartDto;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.Part;
import cz.muni.fi.manager.KitManager;
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
public class KitManagerImpl implements KitManager{

    @Inject
    Mapper mapper;
    
    @Inject 
    KitDao kitDao;
    
    public void createKit(KitDto kitDto) {
        Kit kit =  mapper.map(kitDto, Kit.class);
        kitDao.add(kit);
    }

    public void saveKit(KitDto kitDto) {
        Kit kit =  mapper.map(kitDto, Kit.class);
        kitDao.update(kit);
    }

    public void removeKit(KitDto kitDto) {
        Kit kit =  mapper.map(kitDto, Kit.class);
        kitDao.remove(kit);
    }

    public KitDto getByID(long ID) throws DataAccessException {
        return mapper.map(kitDao.getByID(ID), KitDto.class);
    }
    
    public List<KitDto> getAll() throws DataAccessException {
        List<KitDto> listDto = new ArrayList<KitDto>();
        List<Kit> list = (List<Kit>)kitDao.getAll();
        
        for(Kit item:list)
        {
            listDto.add(mapper.map(item, KitDto.class));
        }
        
        return listDto;
    }

    public void addPartToKit(KitDto kitDto, PartDto partDto) throws DataAccessException {
        kitDao.addPartToKit(mapper.map(kitDto, Kit.class), mapper.map(partDto, Part.class));
    }

    public void removePartFromKit(KitDto kitDto, PartDto partDto) throws DataAccessException {
        kitDao.removePartFromKit(mapper.map(kitDto, Kit.class), mapper.map(partDto, Part.class));
    }
}
