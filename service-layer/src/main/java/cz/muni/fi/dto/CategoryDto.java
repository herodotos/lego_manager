/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dto;

import java.util.Set;

/**
 *
 * @author srogy
 */
public class CategoryDto {
    
    private long id;
    
    private String name;
    
    private String description;
    
    private Set<KitSetDto> kitSets;
    
    private Set<KitDto> kits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<KitSetDto> getKitSets() {
        return kitSets;
    }

    public void setKitSets(Set<KitSetDto> kitSets) {
        this.kitSets = kitSets;
    }

    public Set<KitDto> getKits() {
        return kits;
    }

    public void setKits(Set<KitDto> kits) {
        this.kits = kits;
    }
    
    
}
