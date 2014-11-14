/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.entity;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Ondrej
 */
@Entity
public class PartBlueprint {
    
    @Id 
    @GeneratedValue
    private long id = 0;
    
    private String name;
    
    @ElementCollection
    private Set<Color> availableColors = new HashSet<Color>();

    public PartBlueprint() {
    }

    public PartBlueprint(String name, Set<Color> availableColors) {
        this.name = name;
        this.availableColors = availableColors;
    }
    
    public long getId() {
        return id;
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
