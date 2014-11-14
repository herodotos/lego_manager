/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao;

import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.KitSet;

/**
 *
 * @author srogy
 */
public interface KitSetDao extends GeneralDao{
  
    public void addKitToKitSet(KitSet kitSet, Kit kit);
    
    public void removeKitFromKitSet(KitSet kitSet, Kit kit);
}
