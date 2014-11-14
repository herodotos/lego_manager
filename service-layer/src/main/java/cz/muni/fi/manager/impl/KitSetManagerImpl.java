/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager.impl;

import cz.muni.fi.dao.KitSetDao;
import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.KitSetDto;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;
import cz.muni.fi.manager.KitSetManager;
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
public class KitSetManagerImpl implements KitSetManager{

    @Inject
    Mapper mapper;
    
    @Inject 
    KitSetDao kitSetDao;
    
    public void createKitSet(KitSetDto kitSetDto) {
        KitSet kitSet =  mapper.map(kitSetDto, KitSet.class);
        kitSetDao.add(kitSet);
    }

    public void saveKitSet(KitSetDto kitSetDto) {
        KitSet kitSet =  mapper.map(kitSetDto, KitSet.class);
        kitSetDao.update(kitSet);
    }

    public void removeKitSet(KitSetDto kitSetDto) {
        KitSet kitSet =  mapper.map(kitSetDto, KitSet.class);
        kitSetDao.remove(kitSet);
    }

    public List<KitSetDto> getAll() throws DataAccessException {
        List<KitSetDto> listDto = new ArrayList<KitSetDto>();
        List<KitSet> list = (List<KitSet>)kitSetDao.getAll();
        
        for(KitSet item:list)
        {
            listDto.add(mapper.map(item, KitSetDto.class));
        }
        
        return listDto;
    }

    public KitSetDto getByID(long ID) throws DataAccessException {
        return mapper.map(kitSetDao.getByID(ID), KitSetDto.class);
    }

    public void addKitToKitSet(KitSetDto kitSetDto, KitDto kitDto) throws DataAccessException {
        kitSetDao.addKitToKitSet(mapper.map(kitSetDto, KitSet.class), mapper.map(kitDto, Kit.class));
    }

    public void removeKitFromKitSet(KitSetDto kitSetDto, KitDto kitDto) throws DataAccessException {
        kitSetDao.removeKitFromKitSet(mapper.map(kitSetDto, KitSet.class), mapper.map(kitDto, Kit.class));
    }
    
}
