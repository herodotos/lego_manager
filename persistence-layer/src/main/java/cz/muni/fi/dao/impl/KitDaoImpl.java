/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.KitDao;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.Part;

import java.util.List;

import javax.inject.Named;

/**
 *
 * @author srogy
 */
@Named("kitDao")
public class KitDaoImpl extends GeneralDaoImpl implements KitDao{

    @Override
    public List<Kit> getAll() {
        return entityManager.createQuery("SELECT k FROM Kit k", Kit.class).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Kit getByID(long ID) {
        return (Kit) entityManager.find(Kit.class, ID);
    }

    public void addPartToKit(Kit kit, Part part) {
        kit.getParts().add(part);
        this.update(kit);
    }

    public void removePartFromKit(Kit kit, Part part) {
        kit.getParts().remove(part);
        this.update(kit);
    }
}
