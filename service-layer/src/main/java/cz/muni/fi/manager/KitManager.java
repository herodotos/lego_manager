/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager;

import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.PartDto;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */

public interface KitManager {
    
    public void createKit(KitDto kitDto) throws DataAccessException;
    
    public void saveKit(KitDto kitDto) throws DataAccessException; 
    
    public void removeKit(KitDto kitDto) throws DataAccessException;
    
    public List<KitDto> getAll() throws DataAccessException;
    
    public KitDto getByID(long ID) throws DataAccessException;
    
    public void addPartToKit(KitDto kitDto, PartDto partDto) throws DataAccessException;
            
    public void removePartFromKit(KitDto kitDto, PartDto partDto) throws DataAccessException;
     
     
}
