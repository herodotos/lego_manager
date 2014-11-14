/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao.impl;

import cz.muni.fi.dao.PartBlueprintDao;
import cz.muni.fi.entity.PartBlueprint;

import java.util.List;

import javax.inject.Named;

/**
 *
 * @author srogy
 */
@Named("partBluePrintDao")
public class PartBlueprintDaoImpl extends GeneralDaoImpl implements  PartBlueprintDao{

    @Override
    public List<PartBlueprint> getAll() {
        return entityManager.createQuery("SELECT p FROM PartBlueprint p", PartBlueprint.class).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public PartBlueprint getByID(long ID) {
        return (PartBlueprint) entityManager.find(PartBlueprint.class, ID);
    }
}
