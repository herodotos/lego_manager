/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager.impl;

import cz.muni.fi.dao.PartBlueprintDao;
import cz.muni.fi.dto.CategoryDto;
import cz.muni.fi.dto.PartBlueprintDto;
import cz.muni.fi.entity.PartBlueprint;
import cz.muni.fi.manager.PartBlueprintManager;
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
public class PartBlueprintManagerImpl implements PartBlueprintManager{

    @Inject
    Mapper mapper;
    
    @Inject 
    PartBlueprintDao partBlueprintDao;
    
    public void createPartBlueprint(PartBlueprintDto partBlueprintDto) {
        PartBlueprint partBlueprint =  mapper.map(partBlueprintDto, PartBlueprint.class);
        partBlueprintDao.add(partBlueprint);
    }

    public void savePartBlueprint(PartBlueprintDto partBlueprintDto) {
        PartBlueprint partBlueprint =  mapper.map(partBlueprintDto, PartBlueprint.class);
        partBlueprintDao.update(partBlueprint);
    }

    public void removePartBlueprint(PartBlueprintDto partBlueprintDto) {
        PartBlueprint partBlueprint =  mapper.map(partBlueprintDto, PartBlueprint.class);
        partBlueprintDao.remove(partBlueprint);
    }

    public List<PartBlueprintDto> getAll() throws DataAccessException {
        List<PartBlueprintDto> listDto = new ArrayList<PartBlueprintDto>();
        List<PartBlueprint> list = (List<PartBlueprint>) partBlueprintDao.getAll();

        for (PartBlueprint item : list) {
            listDto.add(mapper.map(item, PartBlueprintDto.class));
        }

        return listDto;
    }

    public PartBlueprintDto getByID(long ID) throws DataAccessException {
        return mapper.map(partBlueprintDao.getByID(ID), PartBlueprintDto.class);
    }
    
}
