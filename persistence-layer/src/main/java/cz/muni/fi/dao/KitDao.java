/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dao;

import cz.muni.fi.entity.Kit;
import cz.muni.fi.entity.Part;

/**
 *
 * @author srogy
 */
public interface KitDao extends GeneralDao{
    
    public void addPartToKit(Kit kit, Part part);
    
    public void removePartFromKit(Kit kit, Part part);
}
