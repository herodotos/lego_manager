package cz.muni.fi.manager;

import cz.muni.fi.dto.PartDto;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */

public interface PartManager {
    
    public void createPart(PartDto partDto) throws DataAccessException;
    
    public void savePart(PartDto partDto) throws DataAccessException; 
    
    public void removePart(PartDto partDto) throws DataAccessException;
    
    public List<PartDto> getAll() throws DataAccessException;
    
    public PartDto getByID(long ID) throws DataAccessException;
}
