/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager.impl;

import cz.muni.fi.dao.PartDao;
import cz.muni.fi.dto.PartDto;
import cz.muni.fi.entity.Part;
import cz.muni.fi.manager.PartManager;
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
public class PartManagerImpl implements PartManager {

    @Inject
    Mapper mapper;

    @Inject
    PartDao partDao;

    public void createPart(PartDto partDto) {
        Part part = mapper.map(partDto, Part.class);
        partDao.add(part);
    }

    public void savePart(PartDto partDto) {
        Part part = mapper.map(partDto, Part.class);
        partDao.update(part);
    }

    public void removePart(PartDto partDto) {
        Part part = mapper.map(partDto, Part.class);
        partDao.remove(part);
    }

    public List<PartDto> getAll() throws DataAccessException {
        List<PartDto> listDto = new ArrayList<PartDto>();
        List<Part> list = (List<Part>) partDao.getAll();

        for (Part item : list) {
            listDto.add(mapper.map(item, PartDto.class));
        }

        return listDto;
    }

    public PartDto getByID(long ID) throws DataAccessException {
        return mapper.map(partDao.getByID(ID), PartDto.class);
    }
}
