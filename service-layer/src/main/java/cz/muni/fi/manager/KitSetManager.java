    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.manager;

import cz.muni.fi.dto.KitDto;
import cz.muni.fi.dto.KitSetDto;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */

public interface KitSetManager {
    
    public void createKitSet(KitSetDto kitSetDto) throws DataAccessException;
    
    public void saveKitSet(KitSetDto kitSetDto) throws DataAccessException; 
    
    public void removeKitSet(KitSetDto kitSetDto) throws DataAccessException;
    
    public List<KitSetDto> getAll() throws DataAccessException;
    
    public KitSetDto getByID(long ID) throws DataAccessException;
    
    public void addKitToKitSet(KitSetDto kitSetDto, KitDto kitDto) throws DataAccessException;
    
    public void removeKitFromKitSet(KitSetDto kitSetDto, KitDto kitDto) throws DataAccessException;
}
