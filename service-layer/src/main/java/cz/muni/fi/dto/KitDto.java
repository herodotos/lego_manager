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
public class KitDto {

    private long id;
    
    private KitSetDto kitSet;
    
    private CategoryDto category;
    
    private String name;
    
    private Set<PartDto> parts;
    
    private int price;
    
    private int ageLimit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public KitSetDto getKitSet() {
        return kitSet;
    }

    public void setKitSet(KitSetDto kitSet) {
        this.kitSet = kitSet;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }
    
    
}
