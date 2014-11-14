package cz.muni.fi.dao;

import java.util.List;

/**
 *
 * @author Ondrej
 */
public interface GeneralDao {
    
    /**
    * Adds entity to DB.
     * @param entity
    */
    public void add(Object entity);
   
    /**
    * Updates entity in DB.
     * @param entity
    */
    public void update(Object entity);
 
    /**
    * Removes entity from DB.
     * @param entity
    */
    public void remove(Object entity);
  
    /**
    * Returns list of all entities present in DB.
    * @return Returns List<? extends Object> if operation was successful, otherwise returns null
    */
    public List<? extends Object> getAll();
    
    /**
    * Returns entity with given ID.
     * @param <T>
     * @param ID
    * @return Returns Object if operation was successful, otherwise returns null
    */
    public <T> T getByID(long ID);
    
}
