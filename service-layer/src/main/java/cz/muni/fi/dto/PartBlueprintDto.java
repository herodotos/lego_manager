/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dto;

import java.awt.Color;
import java.util.Set;

/**
 *
 * @author srogy
 */
public class PartBlueprintDto {

    private long id;
    
    private String name;
    
    private Set<Color> availableColors;

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

    public Set<Color> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(Set<Color> availableColors) {
        this.availableColors = availableColors;
    }
    
    
}
