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
public class KitSetDto {

    private long id;
    
    private CategoryDto category;
    
    private String name;
    
    private Set<KitDto> kits;
    
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<KitDto> getKits() {
        return kits;
    }

    public void setKits(Set<KitDto> kits) {
        this.kits = kits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
