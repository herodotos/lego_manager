/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.GeneralDao;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 *
 * @author srogy
 */
@Named("generalDao")
public class GeneralDaoImpl implements GeneralDao{
  
    @PersistenceContext
     EntityManager entityManager;
    
    @Transactional
    public void add(Object entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public void update(Object entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public void remove(Object entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public List<? extends Object> getAll() {
        return null;
    }

    public <T> T getByID(long ID) {
        return null;
    }
    
}
