/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.dto;

import java.awt.Color;

/**
 *
 * @author srogy
 */
public class PartDto {

    private long id;
    
    private String name;
    
    private Color color;
    
    private PartBlueprintDto blueprint;

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PartBlueprintDto getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(PartBlueprintDto blueprint) {
        this.blueprint = blueprint;
    }
    
    
}
