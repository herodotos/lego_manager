package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.PartDao;
import cz.muni.fi.entity.Part;

import java.util.List;

import javax.inject.Named;

/**
 *
 * @author srogy
 */
@Named("partDao")
public class PartDaoImpl extends GeneralDaoImpl implements PartDao{
    
    @Override
    public List<Part> getAll() {
        return entityManager.createQuery("SELECT p FROM Part p", Part.class).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Part getByID(long ID) {
        return (Part) entityManager.find(Part.class, ID);
    }
}
