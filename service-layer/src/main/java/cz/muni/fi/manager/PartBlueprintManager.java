package cz.muni.fi.manager;

import cz.muni.fi.dto.PartBlueprintDto;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author srogy
 */

public interface PartBlueprintManager {
    
    public void createPartBlueprint(PartBlueprintDto partBlueprintDto) throws DataAccessException;
    
    public void savePartBlueprint(PartBlueprintDto partBlueprintDto) throws DataAccessException; 
    
    public void removePartBlueprint(PartBlueprintDto partBlueprintDto) throws DataAccessException;
    
    public List<PartBlueprintDto> getAll() throws DataAccessException;
    
    public PartBlueprintDto getByID(long ID) throws DataAccessException;
}
