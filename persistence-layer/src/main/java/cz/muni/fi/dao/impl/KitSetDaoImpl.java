/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.KitSetDao;
import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;

import java.util.List;

import javax.inject.Named;

/**
 *
 * @author srogy
 */
@Named("kitSetDao")
public class KitSetDaoImpl extends GeneralDaoImpl implements KitSetDao{

    @Override
    public List<KitSet> getAll() {
        return entityManager.createQuery("SELECT k FROM KitSet k", KitSet.class).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public KitSet getByID(long ID) {
        return (KitSet) entityManager.find(KitSet.class, ID);
    }

    public void addKitToKitSet(KitSet kitSet, Kit kit) {
        kitSet.getKits().add(kit);
        this.update(kitSet);
    }

    public void removeKitFromKitSet(KitSet kitSet, Kit kit) {
        kitSet.getKits().remove(kit);
        this.update(kitSet);    
    }
}
